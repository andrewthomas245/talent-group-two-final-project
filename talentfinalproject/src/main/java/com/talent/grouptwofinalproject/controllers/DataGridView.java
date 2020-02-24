package com.talent.grouptwofinalproject.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.talent.grouptwofinalproject.models.Quote;
import com.talent.grouptwofinalproject.services.QuoteService;

@Named
@ViewScoped
public class DataGridView implements Serializable {
     
    private List<Quote> quotes;
     
    private Quote selectedQuote;
     
    @Inject
    private QuoteService service;

	public List<Quote> getQuotes() {
		return quotes;
	}

	public void setQuotes(List<Quote> quotes) {
		this.quotes = quotes;
	}

	public Quote getSelectedQuote() {
		return selectedQuote;
	}

	public void setSelectedQuote(Quote selectedQuote) {
		this.selectedQuote = selectedQuote;
	}
    
    
}
