package com.lucene.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lucene.entity.Country;
import com.lucene.service.SearchService;


@RestController
public class CryptoCoinController {
	
	@Autowired
	private SearchService searchService;
	
	@GetMapping("wel-come")
	String fetchHeaderInformation() throws Exception{
		return "Wel-come";
	}
	
	@GetMapping("country-list")
	List<Country> fetchAllCountry() throws Exception{
		return searchService.findAll();
	}
	
	@GetMapping("add-index")
	void addIndexForSearch() throws Exception{
		searchService.addIndexForSearch();
	}
	
	@GetMapping("search")
	List<Country> fetchSearchDetails(@RequestParam(required=true,value="searchText") String searchText) throws Exception{
			return searchService.fetchSearchDetails(searchText.toLowerCase());
	}
	
	
}
