package com.kasokuz.snaildb.repository;

import org.springframework.data.repository.CrudRepository;

import com.kasokuz.snaildb.domain.Family;
import com.kasokuz.snaildb.domain.Genus;

public interface GenusRepository extends CrudRepository<Genus, Integer> {
	
	public Genus findByGenusId(Integer genusId);
	
	public Genus findByNameAndFamily(String name, Family family);
	
	public Iterable<Genus> findByNameContaining(String name);

}
