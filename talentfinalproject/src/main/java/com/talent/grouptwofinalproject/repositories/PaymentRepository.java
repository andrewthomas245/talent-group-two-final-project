package com.talent.grouptwofinalproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talent.grouptwofinalproject.entities.Payments;

public interface PaymentRepository extends JpaRepository<Payments, Long>, CustomPaymentRepository {

}
