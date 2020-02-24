package com.talent.grouptwofinalproject.repositories;

import java.util.List;

import com.talent.grouptwofinalproject.entities.Policies;

public interface CustomPolicyRepository {
	List<Policies> getDetailByID(Long id);
	
	List<Policies> getPolicyByQuote(Long id);
	
}
