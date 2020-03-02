package com.talent.grouptwofinalproject.services;

import java.util.List;

import com.talent.grouptwofinalproject.entities.Policies;
import com.talent.grouptwofinalproject.models.*;

public interface PolicyService {
	public void createPolicy(Policy pol);
	
	public List<Policy> getPolicies(Policy pol);
	
	public Policy getQuoteAndPaymentById(Long id);
	
	public List<Policies> findQuoteInPolicy(Long id);
	
	public Boolean checkYearlyPayment(Policy pol);
	
	public String checkStatus(Policy pol);
	
	public Policy getQuoteData(Policy pol,Quote quo);
	
}
