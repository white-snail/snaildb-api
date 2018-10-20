package com.kasokuz.snaildb.module.snail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kasokuz.snaildb.module.snail.entity.*;
import com.kasokuz.snaildb.module.snail.repository.*;

@Service
public class SnailService {
	
	@Autowired
	private TaxonomerRepository taxonomerRepository;
	
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
	
	public Taxonomer saveTaxonomer(Taxonomer taxonomer) {
		return taxonomerRepository.save(taxonomer);
	}

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
	
	public Iterable<Superfamily> getSuperfamilies() {
		return superfamilyRepository.findAll();
	}
	
	// GET BY ID
	
	public Superfamily getSuperfamily(Integer superfamilyId) {
		return superfamilyRepository.findBySuperfamilyId(superfamilyId);
	}
	
	public Family getFamily(Integer familyId) {
		return familyRepository.findByFamilyId(familyId);
	}
	
	public Genus getGenus(Integer genusId) {
		return genusRepository.findByGenusId(genusId);
	}
	
	public Species getSpecies(Integer speciesId) {
		return speciesRepository.findBySpeciesId(speciesId);
	}
	
	public Subspecies getSubspecies(Integer subspeciesId) {
		return subspeciesRepository.findBySubspeciesId(subspeciesId);
	}
	
	// GET BY NAME

	public Superfamily getSuperfamily(String superfamily) {
		return superfamilyRepository.findByName(superfamily);
	}
	
	public Family getFamily(String family, String superfamily) {
		return familyRepository.findByNameAndSuperfamily(family, getSuperfamily(superfamily));
	}
	
	public Genus getGenus(String genus, String superfamily, String family) {
		return genusRepository.findByNameAndFamily(genus, getFamily(family, superfamily));
	}
	
	public Species getSpecies(String species, String superfamily, String family, String genus) {
		return speciesRepository.findByNameAndGenus(species, getGenus(genus, superfamily, family));
	}
	
	public Subspecies getSubspecies(String subspecies, String superfamily, String family, String genus, String species) {
		return subspeciesRepository.findByNameAndSpecies(subspecies, getSpecies(species, superfamily, family, genus));
	}
	
	// DELETE
	
	public void deleteTaxonomer(Integer taxonomerId) {
		taxonomerRepository.deleteById(taxonomerId);
	}

	public void deleteSuperfamily(Integer superfamilyId) {
		superfamilyRepository.deleteById(superfamilyId);
	}
	
	public void deleteFamily(Integer familyId) {
		familyRepository.deleteById(familyId);
	}
	
	public void deleteGenus(Integer genusId) {
		genusRepository.deleteById(genusId);
	}
	
	public void deleteSpecies(Integer speciesId) {
		speciesRepository.deleteById(speciesId);
	}
	
	public void deleteSubspecies(Integer subspeciesId) {
		subspeciesRepository.deleteById(subspeciesId);
	}

}
