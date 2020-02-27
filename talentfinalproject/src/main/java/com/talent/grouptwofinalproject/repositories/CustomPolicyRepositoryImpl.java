package com.talent.grouptwofinalproject.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.talent.grouptwofinalproject.entities.Policies;
import com.talent.grouptwofinalproject.entities.Quotes;
import com.talent.grouptwofinalproject.entities.Users;

public class CustomPolicyRepositoryImpl implements CustomPolicyRepository {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Policies> getDetailByID(Long id) {
		System.out.println("ddddddddddd" + id);

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Policies> cq = cb.createQuery(Policies.class);

		Root<Policies> policy = cq.from(Policies.class);
		System.out.println("ccccc" + id);

		Predicate p = cb.equal(policy.get("policyid"), id);
		cq.where(p).distinct(true);

		TypedQuery<Policies> typedQuery = em.createQuery(cq);
		List<Policies> resultList = typedQuery.getResultList();

		return resultList;
	}

	@Override
	public List<Policies> getPolicyByQuote(Long id) {
		System.out.println("ddddddddddd" + id);

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Policies> cq = cb.createQuery(Policies.class);

		Root<Policies> policy = cq.from(Policies.class);
		System.out.println("ccccc" + id);

		Predicate p = cb.equal(policy.get("quotes"), id);
		cq.where(p).distinct(true);

		TypedQuery<Policies> typedQuery = em.createQuery(cq);
		List<Policies> resultList = typedQuery.getResultList();

		return resultList;
	}

	@Override
	public List<Policies> findByUser(Long id) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Policies> cq = cb.createQuery(Policies.class);

		Root<Policies> policies = cq.from(Policies.class);
		Join<Policies, Quotes> quotes = policies.join("quotes");
		Join<Quotes, Users> users = quotes.join("users");
		List<Predicate> conditions = new ArrayList();
		conditions.add(cb.equal(users.get("userid"), id));

		TypedQuery<Policies> typedQuery = em
				.createQuery(cq.select(policies).where(conditions.toArray(new Predicate[] {})));
		
		List<Policies> resultList = typedQuery.getResultList();

		return resultList;
	}

}
