package com.kasokuz.snaildb.module.snail.repository;

import org.springframework.data.repository.CrudRepository;

import com.kasokuz.snaildb.module.snail.entity.Superfamily;

public interface SuperfamilyRepository extends CrudRepository<Superfamily, Integer> {
	
	public Superfamily findByName(String name);

}
