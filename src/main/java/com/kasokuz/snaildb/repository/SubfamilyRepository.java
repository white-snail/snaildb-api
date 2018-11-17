package com.kasokuz.snaildb.repository;

import org.springframework.data.repository.CrudRepository;

import com.kasokuz.snaildb.domain.Subfamily;

public interface SubfamilyRepository extends CrudRepository<Subfamily, Integer> {
	
	public Subfamily findBySubfamilyId(Integer subfamilyId);

}
