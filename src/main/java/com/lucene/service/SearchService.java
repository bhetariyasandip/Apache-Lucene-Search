package com.lucene.service;

import java.util.List;

import com.lucene.entity.Country;

public interface SearchService {

	List<Country> findAll() throws Exception;

	void addIndexForSearch() throws Exception;

	List<Country> fetchSearchDetails(String lowerCase) throws Exception;
	
}
