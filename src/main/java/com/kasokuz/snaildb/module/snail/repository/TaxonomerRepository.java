package com.kasokuz.snaildb.module.snail.repository;

import org.springframework.data.repository.CrudRepository;

import com.kasokuz.snaildb.module.snail.dto.Taxonomer;

public interface TaxonomerRepository extends CrudRepository<Taxonomer, Integer> {
	
	public Taxonomer findByTaxonomerId(Integer taxonomerId);
	
	public Taxonomer findBySurnameIgnoreCase(String surname);

}
