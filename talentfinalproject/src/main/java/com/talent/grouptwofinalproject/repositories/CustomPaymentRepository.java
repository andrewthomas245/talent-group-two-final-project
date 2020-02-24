package com.talent.grouptwofinalproject.repositories;

import java.util.List;

import com.talent.grouptwofinalproject.entities.Payments;

public interface CustomPaymentRepository {
	
	List<Payments> findDetail(Long id);

}
