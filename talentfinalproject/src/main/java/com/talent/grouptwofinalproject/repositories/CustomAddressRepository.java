package com.talent.grouptwofinalproject.repositories;

import java.util.List;

import com.talent.grouptwofinalproject.entities.Addresses;

public interface CustomAddressRepository {
	List<Addresses> getAddressByID(Long id);
}
