package com.talent.grouptwofinalproject.repositories;

import java.util.List;

import com.talent.grouptwofinalproject.entities.Benificiaries;

public interface CustomBenificiaryRepository {
	List<Benificiaries> getBenificiaryByID(Long id);
}
