package com.kasokuz.snaildb.repository;

import org.springframework.data.repository.CrudRepository;

import com.kasokuz.snaildb.domain.Family;
import com.kasokuz.snaildb.domain.Superfamily;

public interface FamilyRepository extends CrudRepository<Family, Integer> {
	
	public Family findByFamilyId(Integer familyId);

	public Family findByNameAndSuperfamily(String name, Superfamily superfamily);
	
	public Iterable<Family> findByNameContaining(String name);
	
}
