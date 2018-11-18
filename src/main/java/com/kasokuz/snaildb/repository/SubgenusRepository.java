package com.kasokuz.snaildb.repository;

import org.springframework.data.repository.CrudRepository;

import com.kasokuz.snaildb.domain.Subgenus;

public interface SubgenusRepository extends CrudRepository<Subgenus, Integer> {

	public Subgenus findBySubgenusId(Integer subgenusId);
	
}
