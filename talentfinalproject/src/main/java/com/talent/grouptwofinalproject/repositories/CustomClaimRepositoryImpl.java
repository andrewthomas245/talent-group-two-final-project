package com.talent.grouptwofinalproject.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.talent.grouptwofinalproject.entities.Claims;
import com.talent.grouptwofinalproject.entities.Policies;

public class CustomClaimRepositoryImpl implements CustomClaimRepository {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public List<Claims> getClaimByPolicy(Long id) {
		System.out.println("Policy ID at Claim" + id);

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Claims> cq = cb.createQuery(Claims.class);

		Root<Claims> claim = cq.from(Claims.class);
		System.out.println("ccccc" + id);

		Predicate p = cb.equal(claim.get("policies"), id);
		cq.where(p).distinct(true);

		TypedQuery<Claims> typedQuery = em.createQuery(cq);
		List<Claims> resultList = typedQuery.getResultList();

		return resultList;
	}

}
