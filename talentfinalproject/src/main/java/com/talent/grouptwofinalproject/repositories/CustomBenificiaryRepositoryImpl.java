package com.talent.grouptwofinalproject.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.talent.grouptwofinalproject.entities.Benificiaries;

public class CustomBenificiaryRepositoryImpl implements CustomBenificiaryRepository {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Benificiaries> getBenificiaryByID(Long id) {
		System.out.println("ddddddddddd" + id);

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Benificiaries> cq = cb.createQuery(Benificiaries.class);

		Root<Benificiaries> benificiary = cq.from(Benificiaries.class);
		System.out.println("ccccc" + id);

		Predicate p = cb.equal(benificiary.get("benificiaryid"), id);
		cq.where(p).distinct(true);

		TypedQuery<Benificiaries> typedQuery = em.createQuery(cq);
		List<Benificiaries> resultList = typedQuery.getResultList();

		return resultList;
	}

}
