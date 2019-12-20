package com.lucene.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.lucene.entity.Country;

@Transactional
public interface CountryRepository extends JpaRepository<Country, Long>, JpaSpecificationExecutor<Country> {

	
}
