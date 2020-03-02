package com.talent.grouptwofinalproject.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.talent.grouptwofinalproject.entities.Claims;
import com.talent.grouptwofinalproject.models.Payment;
import com.talent.grouptwofinalproject.models.Policy;
import com.talent.grouptwofinalproject.services.ClaimService;
import com.talent.grouptwofinalproject.services.PaymentService;

@Named
@ViewScoped
public class PaymentController {

	private Payment payment = new Payment();

	List<Payment> payments = new ArrayList<>();

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	private boolean skip;

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	@Autowired
	public PaymentService paymentService;
	
	@Autowired
	public ClaimService claimService;

	public String getToPayment(Policy pol) {
		List<Claims> findclaims = claimService.findPolicyInClaims(pol.getId());
		if (!findclaims.isEmpty()) {
			System.out.println("DUPLICATE");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("Error",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fail", "You can't pay anymore premiums as this policy is already claimed."));
			context.getExternalContext().getFlash().setKeepMessages(true);
		} else {
			boolean checkpaidpremium = paymentService.checkTotalPayment(pol);
			System.out.println(checkpaidpremium);

			if (!checkpaidpremium) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage("Error", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fail",
						"You have already paid premium in full."));
				context.getExternalContext().getFlash().setKeepMessages(true);
			} else {
				System.out.println("Here");
				payment.setPolicyid(pol.getId());
				System.out.println(payment.getPolicyid());
				return "/user/payment.xhtml?faces-redirect=true";
			}
		}
		return null;
	}

	public String save() {
		paymentService.createPayment(payment);

		FacesMessage msg = new FacesMessage("Successful",
				"The Amount: " + payment.getPaymentamount() + " is paid successfully.");

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, msg);
		context.getExternalContext().getFlash().setKeepMessages(true);

		payment = new Payment();

		return "/user/mypolicies.xhtml?faces-redirect=true";
	}

}
