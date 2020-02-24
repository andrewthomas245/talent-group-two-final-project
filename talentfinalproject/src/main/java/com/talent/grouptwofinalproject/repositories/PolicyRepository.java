package com.talent.grouptwofinalproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talent.grouptwofinalproject.entities.Policies;

public interface PolicyRepository extends JpaRepository<Policies, Long>, CustomPolicyRepository {

}
