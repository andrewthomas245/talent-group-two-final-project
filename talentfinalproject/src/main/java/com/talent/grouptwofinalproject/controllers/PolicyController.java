package com.talent.grouptwofinalproject.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;

import com.talent.grouptwofinalproject.entities.Policies;
import com.talent.grouptwofinalproject.models.Claim;
import com.talent.grouptwofinalproject.models.Policy;
import com.talent.grouptwofinalproject.models.Quote;
import com.talent.grouptwofinalproject.services.*;

@Named
@ViewScoped
public class PolicyController {

	private Policy policy = new Policy();

	private List<Policy> policies = new ArrayList<>();

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public List<Policy> getPolicies() {
		return policies;
	}

	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
	}

	private boolean skip;

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	public String getToPolicy(Quote quo) {
		System.out.println("Start: " + quo.getId());
		List<Policies> findpolicies = policyService.findQuoteInPolicy(quo.getId());
		System.out.println(findpolicies);
		if (!findpolicies.isEmpty()) {
			System.out.println("DUPLICATE");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("Error", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fail",
					"There is a policy already created with this quote."));
			context.getExternalContext().getFlash().setKeepMessages(true);
		} else {
			System.out.println("Here");
			policy.setQuoteid(quo.getId());
			policy.setQuotename(quo.getName());
			policy.setQuotenrc(quo.getNrc());
			policy.setPremiumplan(quo.getPremiumplan());
			policy.setPolicyterm(quo.getPolicyterm());
			policy.setMonthlypremium(quo.getMonthlypremium());
			policy.setQuarterlypremium(quo.getQuarterlypremium());
			policy.setHalfyearpremium(quo.getHalfyearpremium());
			policy.setYearlypremium(quo.getYearlypremium());
			System.out.println(policy.getQuoteid());
			return "/buypolicy.xhtml?faces-redirect=true";
		}
		return null;
	}

	@Autowired
	public PolicyService policyService;

	public String save() {
		System.out.println(policy.getQuotename());
		policyService.createPolicy(policy);
		FacesMessage msg = new FacesMessage("Successful",
				"Policy with Quote Name: " + policy.getQuotename() + " is created successfully.");

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, msg);
		context.getExternalContext().getFlash().setKeepMessages(true);

		return "/mypolicies.xhtml?faces-redirect=true";
	}

	public void fetchAll() {
		policy = new Policy();
		// quotes = quoteservice.getAllQuotes();
		policies = policyService.getPolicies(policy);
	}

	public String fetchByQuote(Long id) {
		policy = policyService.getQuoteAndPaymentById(id);
		return "/policydetail.xhtml?faces-redirect=true";
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
