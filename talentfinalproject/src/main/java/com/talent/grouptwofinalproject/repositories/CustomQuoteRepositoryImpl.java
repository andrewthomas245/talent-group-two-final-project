package com.talent.grouptwofinalproject.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.talent.grouptwofinalproject.entities.Quotes;

public class CustomQuoteRepositoryImpl implements CustomQuoteRepository {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Quotes> getQuoteDetailByID(Long id) {
		System.out.println("ddddddddddd" + id);

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Quotes> cq = cb.createQuery(Quotes.class);

		Root<Quotes> quote = cq.from(Quotes.class);
		System.out.println("ccccc" + id);

		Predicate p = cb.equal(quote.get("quoteid"), id);
		cq.where(p).distinct(true);

		TypedQuery<Quotes> typedQuery = em.createQuery(cq);
		List<Quotes> resultList = typedQuery.getResultList();

		return resultList;
	}

}
