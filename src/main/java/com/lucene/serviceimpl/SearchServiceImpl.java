package com.lucene.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Service;

import com.lucene.entity.Country;
import com.lucene.repository.CountryRepository;
import com.lucene.service.BasicService;
import com.lucene.service.SearchService;

@Service
public class SearchServiceImpl extends BasicService<Country, CountryRepository> implements SearchService, Cloneable {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void addIndexForSearch() throws Exception {
		// TODO Auto-generated method stub
		FullTextEntityManager fullTextEntityManagerAdd = Search.getFullTextEntityManager(em);
		fullTextEntityManagerAdd.createIndexer().startAndWait();
	}

	@Override
	public List<Country> fetchSearchDetails(String searchText) throws Exception {
		// TODO Auto-generated method stub
		
		FullTextEntityManager fullTextEntityManager =org.hibernate.search.jpa.Search.getFullTextEntityManager(em);
		QueryBuilder queryBuilder = 
				fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Country.class).get();
		//org.apache.lucene.search.Query query = queryBuilder.keyword().onFields("name","symbol").matching(searchText).createQuery();
		org.apache.lucene.search.Query query =queryBuilder.keyword().wildcard().onFields("countryName","continentName").matching(searchText+"*").createQuery();
		
		
		Sort sort = new Sort(new SortField("rank", SortField.Type.LONG, false));
		
		org.hibernate.search.jpa.FullTextQuery jpaQuery =
			      fullTextEntityManager.createFullTextQuery(query, Country.class);
		jpaQuery.setSort(sort);
		@SuppressWarnings("unchecked")
	    List<Country> results = jpaQuery.getResultList();
		return results;
	}


}
