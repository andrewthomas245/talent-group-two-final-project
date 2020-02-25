package com.talent.grouptwofinalproject.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;

import com.talent.grouptwofinalproject.entities.Policies;
import com.talent.grouptwofinalproject.models.Quote;
import com.talent.grouptwofinalproject.services.PolicyService;
import com.talent.grouptwofinalproject.services.QuoteService;

@Named
@ViewScoped
public class QuoteController {
	private Quote quote = new Quote();

	private List<Quote> quotes = new ArrayList<>();

	public Quote getQuote() {
		return quote;
	}

	public void setQuote(Quote quote) {
		this.quote = quote;
	}

	public List<Quote> getQuotes() {
		return quotes;
	}

	public void setQuotes(List<Quote> quotes) {
		this.quotes = quotes;
	}

	private boolean skip;

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	@Autowired
	public QuoteService quoteservice;

	@Autowired
	public PolicyService policyservice;

	public String save() {
		quoteservice.createQuote(quote);
		FacesMessage msg = new FacesMessage("Successful",
				"Quote with Name: " + quote.getName() + " is created successfully.");

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, msg);
		context.getExternalContext().getFlash().setKeepMessages(true);

		quote = new Quote();

		return "/myquotes.xhtml?faces-redirect=true";

	}
	
	public String edit() {
		quoteservice.updateQuote(quote);
		FacesMessage msg = new FacesMessage("Successful",
				"Quote with Name: " + quote.getName() + " is edited successfully.");

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, msg);
		context.getExternalContext().getFlash().setKeepMessages(true);

		quote = new Quote();

		return "/myquotes.xhtml?faces-redirect=true";

	}
	
	public String getToEdit(Quote quo) {
		System.out.println("Start: " + quo.getId());
		List<Policies> findpolicies = policyservice.findQuoteInPolicy(quo.getId());
		System.out.println(findpolicies);
		if (!findpolicies.isEmpty()) {
			System.out.println("DUPLICATE");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("Error", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fail",
					"There is a policy already created with this quote."));
			context.getExternalContext().getFlash().setKeepMessages(true);
		} else {
			System.out.println("Here");
			return "/editquote.xhtml?faces-redirect=true";
		}
		return null;
	}

	public String confirm() {
		quote = quoteservice.calculate(quote);
		return "/confirmquote.xhtml?faces-redirect=true";
	}
	
	public String confirmedited() {
		quote = quoteservice.calculate(quote);
		return "/confirmeditedquote.xhtml?faces-redirect=true";
	}

	public void fetchAll() {
		quotes = quoteservice.getQuotes(quote);
	}

	public String fetchByQuote(Long id) {
		quote = quoteservice.getQuoteDetailById(id);
		return "/quotedetail.xhtml?faces-redirect=true";
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
