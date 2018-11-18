package com.kasokuz.snaildb.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kasokuz.snaildb.domain.Family;
import com.kasokuz.snaildb.domain.Genus;
import com.kasokuz.snaildb.domain.Species;
import com.kasokuz.snaildb.domain.Subfamily;
import com.kasokuz.snaildb.domain.Subgenus;
import com.kasokuz.snaildb.domain.Subspecies;
import com.kasokuz.snaildb.domain.Superfamily;
import com.kasokuz.snaildb.domain.Taxonomer;
import com.kasokuz.snaildb.repository.FamilyRepository;
import com.kasokuz.snaildb.repository.GenusRepository;
import com.kasokuz.snaildb.repository.SpeciesRepository;
import com.kasokuz.snaildb.repository.SubfamilyRepository;
import com.kasokuz.snaildb.repository.SubgenusRepository;
import com.kasokuz.snaildb.repository.SubspeciesRepository;
import com.kasokuz.snaildb.repository.SuperfamilyRepository;
import com.kasokuz.snaildb.repository.TaxonomerRepository;

@Service
public class SnailService {
	
	@Autowired
	private TaxonomerRepository taxonomerRepository;
	
	@Autowired
	private SuperfamilyRepository superfamilyRepository;
	
	@Autowired
	private FamilyRepository familyRepository;
	
	@Autowired
	private SubfamilyRepository subfamilyRepository;
	
	@Autowired
	private GenusRepository genusRepository;
	
	@Autowired
	private SubgenusRepository subgenusRepository;
	
	@Autowired
	private SpeciesRepository speciesRepository;
	
	@Autowired
	private SubspeciesRepository subspeciesRepository;
	
	// SAVE
	
	@Transactional
	public Taxonomer saveTaxonomer(Taxonomer taxonomer) {
		return taxonomerRepository.save(taxonomer);
	}

	@Transactional
	public Superfamily saveSuperfamily(Superfamily superfamily) {
		return superfamilyRepository.save(superfamily);
	}

	@Transactional
	public Family saveFamily(Family family) {
		return familyRepository.save(family);
	}
	
	@Transactional
	public Subfamily saveSubfamily(Subfamily subfamily) {
		return subfamilyRepository.save(subfamily);
	}
	
	@Transactional
	public Genus saveGenus(Genus genus) {
		return genusRepository.save(genus);
	}
	
	@Transactional
	public Subgenus saveSubgenus(Subgenus subgenus) {
		return subgenusRepository.save(subgenus);
	}

	@Transactional
	public Species saveSpecies(Species species) {
		return speciesRepository.save(species);
	}

	@Transactional
	public Subspecies saveSubspecies(Subspecies subspecies) {
		return subspeciesRepository.save(subspecies);
	}
	
	// GET ALLL
	
	public Iterable<Taxonomer> getTaxonomers() {
		return taxonomerRepository.findAll();
	}
	
	public Iterable<Superfamily> getSuperfamilies() {
		return superfamilyRepository.findAll();
	}
	
	public Iterable<Family> getFamilies() {
		return familyRepository.findAll();
	}
	
	public Iterable<Subfamily> getSubfamilies() {
		return subfamilyRepository.findAll();
	}
	
	public Iterable<Genus> getGenera() {
		return genusRepository.findAll();
	}
	
	public Iterable<Subgenus> getSubgenera() {
		return subgenusRepository.findAll();
	}
	
	public Iterable<Species> getSpecies() {
		return speciesRepository.findAll();
	}
	
	public Iterable<Subspecies> getSubspecies() {
		return subspeciesRepository.findAll();
	}
	
	// GET RANDOM
	
	public Species getRandomSpecies() {
		return speciesRepository.findRandom();
	}
	
	// GET BY ID
	
	public Taxonomer getTaxonomer(Integer taxonomerId) {
		return taxonomerRepository.findByTaxonomerId(taxonomerId);
	}
	
	public Superfamily getSuperfamily(Integer superfamilyId) {
		return superfamilyRepository.findBySuperfamilyId(superfamilyId);
	}
	
	public Family getFamily(Integer familyId) {
		return familyRepository.findByFamilyId(familyId);
	}
	
	public Subfamily getSubfamily(Integer subfamilyId) {
		return subfamilyRepository.findBySubfamilyId(subfamilyId);
	}
	
	public Genus getGenus(Integer genusId) {
		return genusRepository.findByGenusId(genusId);
	}
	
	public Subgenus getSubgenus(Integer subgenusId) {
		return subgenusRepository.findBySubgenusId(subgenusId);
	}
	
	public Species getSpecies(Integer speciesId) {
		return speciesRepository.findBySpeciesId(speciesId);
	}
	
	public Subspecies getSubspecies(Integer subspeciesId) {
		return subspeciesRepository.findBySubspeciesId(subspeciesId);
	}
	
	// GET BY NAME
	
	public Taxonomer getTaxonomer(String surname) {
		return taxonomerRepository.findBySurnameIgnoreCase(surname);
	}

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
	
	// SEARCH
	
	public Iterable<Superfamily> searchSuperfamilies(String query) {
		return superfamilyRepository.findByNameContaining(query);
	}
	
	public Iterable<Family> searchFamilies(String query) {
		return familyRepository.findByNameContaining(query);
	}
	
	public Iterable<Genus> searchGenuses(String query) {
		return genusRepository.findByNameContaining(query);
	}
	
	public Iterable<Species> searchSpecies(String query) {
		return speciesRepository.findByNameContaining(query);
	}
	
	public Iterable<Subspecies> searchSubspecies(String query) {
		return subspeciesRepository.findByNameContaining(query);
	}
	
	// COUNT
	
	public Long countTaxonomers() {
		return taxonomerRepository.count();
	}
	
	public Long countSuperfamilies() {
		return superfamilyRepository.count();
	}
	
	public Long countFamilies() {
		return familyRepository.count();
	}
	
	public Long countGenuses() {
		return genusRepository.count();
	}
	
	public Long countSpecies() {
		return speciesRepository.count();
	}
	
	public Long countSubspecies() {
		return subspeciesRepository.count();
	}
	
	public Long countSpeciesNotExtinct() {
		return speciesRepository.countByExtinct(false);
	}
	
	// DELETE
	
	@Transactional
	public void deleteTaxonomer(Integer taxonomerId) {
		taxonomerRepository.deleteById(taxonomerId);
	}
	
	@Transactional
	public void deleteSuperfamily(Integer superfamilyId) {
		superfamilyRepository.deleteById(superfamilyId);
	}
	
	@Transactional
	public void deleteFamily(Integer familyId) {
		familyRepository.deleteById(familyId);
	}
	
	@Transactional
	public void deleteSubfamily(Integer subfamilyId) {
		subfamilyRepository.deleteById(subfamilyId);
	}
	
	@Transactional
	public void deleteGenus(Integer genusId) {
		genusRepository.deleteById(genusId);
	}
	
	@Transactional
	public void deleteSubgenus(Integer subgenusId) {
		subgenusRepository.deleteById(subgenusId);
	}
	
	@Transactional
	public void deleteSpecies(Integer speciesId) {
		speciesRepository.deleteById(speciesId);
	}
	
	@Transactional
	public void deleteSubspecies(Integer subspeciesId) {
		subspeciesRepository.deleteById(subspeciesId);
	}

}
