package com.talent.grouptwofinalproject.repositories;

import java.util.List;

import com.talent.grouptwofinalproject.entities.Claims;

public interface CustomClaimRepository {

	List<Claims> getClaimByPolicy(Long id);

}
