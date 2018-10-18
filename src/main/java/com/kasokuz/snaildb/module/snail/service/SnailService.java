package com.kasokuz.snaildb.module.snail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kasokuz.snaildb.module.snail.entity.Family;
import com.kasokuz.snaildb.module.snail.entity.Genus;
import com.kasokuz.snaildb.module.snail.entity.Species;
import com.kasokuz.snaildb.module.snail.entity.Subspecies;
import com.kasokuz.snaildb.module.snail.entity.Superfamily;
import com.kasokuz.snaildb.module.snail.repository.*;

@Service
public class SnailService {
	
	@Autowired
	private SuperfamilyRepository superfamilyRepository;
	
	@Autowired
	private FamilyRepository familyRepository;
	
	@Autowired
	private GenusRepository genusRepository;
	
	@Autowired
	private SpeciesRepository speciesRepository;
	
	@Autowired
	private SubspeciesRepository subspeciesRepository;
	
	// SAVE

	public Superfamily saveSuperfamily(Superfamily superfamily) {
		return superfamilyRepository.save(superfamily);
	}

	public Family saveFamily(Family family) {
		return familyRepository.save(family);
	}
	
	public Genus saveGenus(Genus genus) {
		return genusRepository.save(genus);
	}

	public Species saveSpecies(Species species) {
		return speciesRepository.save(species);
	}

	public Subspecies saveSubspecies(Subspecies subspecies) {
		return subspeciesRepository.save(subspecies);
	}
	
	// GET

	public Superfamily getSuperfamily(String name) {
		return superfamilyRepository.findByName(name);
	}
	
	// DELETE

	public void deleteSuperfamily(Integer superfamilyId) {
		superfamilyRepository.deleteById(superfamilyId);
	}

}
