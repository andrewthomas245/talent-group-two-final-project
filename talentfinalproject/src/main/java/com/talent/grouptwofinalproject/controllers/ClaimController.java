package com.talent.grouptwofinalproject.controllers;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;

import com.talent.grouptwofinalproject.entities.Claims;
import com.talent.grouptwofinalproject.entities.Policies;
import com.talent.grouptwofinalproject.models.Claim;
import com.talent.grouptwofinalproject.models.Policy;
import com.talent.grouptwofinalproject.services.ClaimService;
import com.talent.grouptwofinalproject.services.PolicyService;

@Named
@ViewScoped
public class ClaimController {
	private Claim claim = new Claim();

	public Claim getClaim() {
		return claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}

	private boolean skip;

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	@Autowired
	public PolicyService policyService;

	@Autowired
	public ClaimService claimService;

	public String getToClaim(Policy pol) {
		List<Claims> findclaims = claimService.findPolicyInClaims(pol.getId());
		if (!findclaims.isEmpty()) {
			System.out.println("DUPLICATE");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("Error",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fail", "This policy is already claimed."));
			context.getExternalContext().getFlash().setKeepMessages(true);
		} else {
			boolean checkpaidpremium = policyService.checkYearlyPayment(pol);
			System.out.println(checkpaidpremium);

			String checkpolicystatus = policyService.checkStatus(pol);
			System.out.println(checkpolicystatus);

			if (checkpaidpremium) {
				FacesContext context2 = FacesContext.getCurrentInstance();
				context2.addMessage("Error", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fail",
						"Your policy's yearly premium has not been fully paid."));
				context2.getExternalContext().getFlash().setKeepMessages(true);
			} else if (checkpolicystatus.equals("Pending")) {
				FacesContext context3 = FacesContext.getCurrentInstance();
				context3.addMessage("Error",
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fail", "Your policy status is not ACTIVE."));
				context3.getExternalContext().getFlash().setKeepMessages(true);
			} else {
				System.out.println("Here at claim");
				claim.setPolicyid(pol.getId());
				System.out.println(claim.getPolicyid());
				return "/claim.xhtml?faces-redirect=true";
			}
		}
		return null;
	}

	public String store() {
		claimService.storeClaim(claim);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage("Success",
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "This policy is successfully claimed."));
		context.getExternalContext().getFlash().setKeepMessages(true);

		claim = new Claim();

		return "/claimsuccess.xhtml?faces-redirect=true";
	}

	public String onFlowProcess(FlowEvent event) {
		if (skip) {
			skip = false; // reset in case user goes back
			return "confirm";
		} else {
			return event.getNewStep();
		}
	}
}