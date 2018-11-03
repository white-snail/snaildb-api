package com.kasokuz.snaildb.module.snail.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kasokuz.snaildb.module.snail.domain.Species;
import com.kasokuz.snaildb.module.snail.domain.Subspecies;

public interface SubspeciesRepository extends CrudRepository<Subspecies, Integer> {
	
	public Subspecies findBySubspeciesId(Integer subspeciesId);
	
	public Subspecies findByNameAndSpecies(String name, Species species);
	
	public Iterable<Subspecies> findByNameContaining(String name);
	
	@Query(value = "select * from snail_subspecies order by rand() limit 1", nativeQuery = true)
	public Subspecies findRandom();

}
