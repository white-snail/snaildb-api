package com.kasokuz.snaildb.module.snail.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kasokuz.snaildb.module.snail.domain.Genus;
import com.kasokuz.snaildb.module.snail.domain.Species;

public interface SpeciesRepository extends CrudRepository<Species, Integer> {
	
	public Species findBySpeciesId(Integer speciesId);

	public Species findByNameAndGenus(String name, Genus genus);
	
	public Iterable<Species> findByNameContaining(String name);
	
	@Query(value = "select * from snail_species order by rand() limit 1", nativeQuery = true)
	public Species findRandom();
	
}
