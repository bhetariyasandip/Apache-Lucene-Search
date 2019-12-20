package com.lucene.service;

import java.util.List;

public interface IService<T>{
	
	T save(T entity);
	
	List<T> saveAll(Iterable<T> entities);

	T findById(Long id);

	/**
	 * Delete the entity
	 * 
	 * @return TODO
	 * 
	 * @return the Redis id deleted
	 * @param id
	 *            identificator
	 */
	Long deleteById(Long id);
}
