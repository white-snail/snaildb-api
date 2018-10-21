package com.kasokuz.snaildb.module.snail.repository;

import org.springframework.data.repository.CrudRepository;

import com.kasokuz.snaildb.module.snail.dto.Genus;
import com.kasokuz.snaildb.module.snail.dto.Species;

public interface SpeciesRepository extends CrudRepository<Species, Integer> {
	
	public Species findBySpeciesId(Integer speciesId);

	public Species findByNameAndGenus(String name, Genus genus);
	
	public Iterable<Species> findByNameContaining(String name);
	
}
