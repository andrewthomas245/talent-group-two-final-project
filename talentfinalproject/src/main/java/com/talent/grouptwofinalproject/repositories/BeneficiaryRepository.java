package com.talent.grouptwofinalproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talent.grouptwofinalproject.entities.*;

public interface BeneficiaryRepository extends JpaRepository<Benificiaries, Long>, CustomBenificiaryRepository {
}
