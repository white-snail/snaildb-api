package com.kasokuz.snaildb.module.snail.repository;

import org.springframework.data.repository.CrudRepository;

import com.kasokuz.snaildb.module.snail.dto.Family;
import com.kasokuz.snaildb.module.snail.dto.Superfamily;

public interface FamilyRepository extends CrudRepository<Family, Integer> {
	
	public Family findByFamilyId(Integer familyId);

	public Family findByNameAndSuperfamily(String name, Superfamily superfamily);
	
	public Iterable<Family> findByNameContaining(String name);
	
}
