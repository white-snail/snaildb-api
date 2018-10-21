package com.kasokuz.snaildb.module.snail.repository;

import org.springframework.data.repository.CrudRepository;

import com.kasokuz.snaildb.module.snail.dto.Family;
import com.kasokuz.snaildb.module.snail.dto.Genus;

public interface GenusRepository extends CrudRepository<Genus, Integer> {
	
	public Genus findByGenusId(Integer genusId);
	
	public Genus findByNameAndFamily(String name, Family family);
	
	public Iterable<Genus> findByNameContaining(String name);

}
