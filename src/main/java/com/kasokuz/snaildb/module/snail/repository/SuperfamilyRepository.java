package com.kasokuz.snaildb.module.snail.repository;

import org.springframework.data.repository.CrudRepository;

import com.kasokuz.snaildb.module.snail.dto.Superfamily;

public interface SuperfamilyRepository extends CrudRepository<Superfamily, Integer> {
	
	public Superfamily findBySuperfamilyId(Integer superfamilyId);
	
	public Superfamily findByName(String name);
	
	public Iterable<Superfamily> findByNameContaining(String name);

}
