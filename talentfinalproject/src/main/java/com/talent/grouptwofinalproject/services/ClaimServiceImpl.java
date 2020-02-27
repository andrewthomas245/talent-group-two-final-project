package com.talent.grouptwofinalproject.services;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talent.grouptwofinalproject.entities.Claims;
import com.talent.grouptwofinalproject.entities.Policies;
import com.talent.grouptwofinalproject.models.Claim;
import com.talent.grouptwofinalproject.repositories.ClaimRepository;

@Service
@Transactional
public class ClaimServiceImpl implements ClaimService {
	
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	public ClaimRepository claimRepository;

	@Override
	public void storeClaim(Claim claim) {
		Claims claimEntity= new Claims();
		
		Date date = new Date();
		
		claimEntity.setClaimdate(date);
		claimEntity.setPaymentdate(date);
		claimEntity.setReviewdate(date);
		
		claimEntity.setClaimreason(claim.getClaimreason());
		
		Policies attachedPolicy = em.find(Policies.class, claim.getPolicyid());
		attachedPolicy.setPolicystatus("Claimed");
		claimEntity.setPolicies(attachedPolicy);
		
		claimRepository.save(claimEntity);
		
	}

	@Override
	public List<Claims> findPolicyInClaims(Long id) {
		System.out.println("Finding: "+ id);
		List<Claims> entitylist = claimRepository.getClaimByPolicy(id);
		System.out.println(entitylist);
		return entitylist;
	}

}
