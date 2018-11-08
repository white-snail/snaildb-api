package com.kasokuz.snaildb.repository;

import org.springframework.data.repository.CrudRepository;

import com.kasokuz.snaildb.domain.Superfamily;

public interface SuperfamilyRepository extends CrudRepository<Superfamily, Integer> {
	
	public Superfamily findBySuperfamilyId(Integer superfamilyId);
	
	public Superfamily findByName(String name);
	
	public Iterable<Superfamily> findByNameContaining(String name);

}
