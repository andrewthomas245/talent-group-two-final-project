package com.talent.grouptwofinalproject.repositories;

import java.util.List;

import com.talent.grouptwofinalproject.entities.Quotes;

public interface CustomQuoteRepository {
	
	List<Quotes> getQuoteDetailByID(Long id);

	List<Quotes> getQuoteByUserID(Long id);
}
