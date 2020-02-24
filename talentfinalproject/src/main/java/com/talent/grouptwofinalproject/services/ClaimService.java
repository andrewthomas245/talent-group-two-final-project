package com.talent.grouptwofinalproject.services;

import java.util.List;

import com.talent.grouptwofinalproject.entities.Claims;
import com.talent.grouptwofinalproject.models.Claim;

public interface ClaimService {
	public void storeClaim(Claim claim);
	
	public List<Claims> findPolicyInClaims(Long id);
}
