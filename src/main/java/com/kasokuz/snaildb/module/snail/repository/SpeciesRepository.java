package com.kasokuz.snaildb.module.snail.repository;

import org.springframework.data.repository.CrudRepository;

import com.kasokuz.snaildb.module.snail.entity.Genus;
import com.kasokuz.snaildb.module.snail.entity.Species;

public interface SpeciesRepository extends CrudRepository<Species, Integer> {

	public Species findByNameAndGenus(String name, Genus genus);
	
}
