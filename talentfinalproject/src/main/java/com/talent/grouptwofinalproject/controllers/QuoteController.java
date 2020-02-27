package com.talent.grouptwofinalproject.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.FlowEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.DateViewChangeEvent;
import org.springframework.beans.factory.annotation.Autowired;

import com.talent.grouptwofinalproject.entities.Policies;
import com.talent.grouptwofinalproject.models.Quote;
import com.talent.grouptwofinalproject.services.PolicyService;
import com.talent.grouptwofinalproject.services.QuoteService;
import com.talent.grouptwofinalproject.services.UserService;

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
	public UserService userservice;

	@Autowired
	public QuoteService quoteservice;

	@Autowired
	public PolicyService policyservice;

	public String save() {
		quote.setUsername(userservice.getLoginUserName());
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

	public String delete(Quote quo) {
		System.out.println("Start: " + quo.getId());
		List<Policies> findpolicies = policyservice.findQuoteInPolicy(quo.getId());
		System.out.println(findpolicies);
		if (!findpolicies.isEmpty()) {
			System.out.println("DUPLICATE");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("Error", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fail",
					"This quote can't be deleted as there is a policy already created with this quote."));
			context.getExternalContext().getFlash().setKeepMessages(true);
		} else {
			System.out.println(quo.getId());

			quoteservice.deleteQuote(quo.getId());
			FacesMessage msg = new FacesMessage("Successful",
					"Quote with Name: " + quote.getName() + " is deleted successfully.");

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, msg);
			context.getExternalContext().getFlash().setKeepMessages(true);

			quote = new Quote();

			return "/myquotes.xhtml?faces-redirect=true";
		}
		return null;

	}

	public String getToEdit(Quote quo) {
		System.out.println("Start: " + quo.getId());
		List<Policies> findpolicies = policyservice.findQuoteInPolicy(quo.getId());
		System.out.println(findpolicies);
		if (!findpolicies.isEmpty()) {
			System.out.println("DUPLICATE");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("Error", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fail",
					"This quote can't be edited as there is a policy already created with this quote."));
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
	
	int currentyear = Calendar.getInstance().get(Calendar.YEAR);
	
	public void onDateSelect(SelectEvent event) {
	    int yearfrombirthdate = quote.getDob().getYear();
	    int birthyear;

	    birthyear=1900+yearfrombirthdate;
	    
	    int age=currentyear-birthyear;
	    quote.setAge(age);
	}
}
