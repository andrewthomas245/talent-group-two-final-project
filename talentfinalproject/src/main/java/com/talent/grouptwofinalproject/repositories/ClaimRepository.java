package com.talent.grouptwofinalproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talent.grouptwofinalproject.entities.Claims;

public interface ClaimRepository extends JpaRepository<Claims, Long>, CustomClaimRepository {

}
