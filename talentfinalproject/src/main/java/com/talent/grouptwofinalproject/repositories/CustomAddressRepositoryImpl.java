package com.talent.grouptwofinalproject.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.talent.grouptwofinalproject.entities.Addresses;

public class CustomAddressRepositoryImpl implements CustomAddressRepository {
	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Addresses> getAddressByID(Long id) {
		System.out.println("ddddddddddd" + id);

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Addresses> cq = cb.createQuery(Addresses.class);

		Root<Addresses> address = cq.from(Addresses.class);
		System.out.println("ccccc" + id);

		Predicate p = cb.equal(address.get("addressid"), id);
		cq.where(p).distinct(true);

		TypedQuery<Addresses> typedQuery = em.createQuery(cq);
		List<Addresses> resultList = typedQuery.getResultList();

		return resultList;
	}

}
