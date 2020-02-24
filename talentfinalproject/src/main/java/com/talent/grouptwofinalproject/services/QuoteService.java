package com.talent.grouptwofinalproject.services;

import java.util.List;

import com.talent.grouptwofinalproject.models.Quote;

public interface QuoteService {
	public void createQuote(Quote quo);
	
	public List<Quote> getQuotes(Quote quo);
	
	public Quote getQuoteDetailById(Long id);
	
	public Quote calculate(Quote quo);
}
