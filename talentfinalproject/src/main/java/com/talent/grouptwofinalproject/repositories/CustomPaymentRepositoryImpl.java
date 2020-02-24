package com.talent.grouptwofinalproject.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.talent.grouptwofinalproject.entities.Payments;

public class CustomPaymentRepositoryImpl implements CustomPaymentRepository{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public List<Payments> findDetail(Long id) {
		
		System.out.println("ddddddddddd" + id);

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Payments> cq = cb.createQuery(Payments.class);

		Root<Payments> payment = cq.from(Payments.class);
		System.out.println("ccccc" + id);

		Predicate p = cb.equal(payment.get("policies"), id);
		cq.where(p).distinct(true);

		TypedQuery<Payments> typedQuery = em.createQuery(cq);
		List<Payments> resultList = typedQuery.getResultList();

		return resultList;
	}

}
