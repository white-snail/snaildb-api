package com.kasokuz.snaildb.module.snail;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kasokuz.snaildb.module.snail.domain.*;
import com.kasokuz.snaildb.module.snail.service.SnailService;

@SpringBootTest
public abstract class SnailTest {
	
	@Autowired
	private SnailService service;
	
	protected Taxonomer swainson, albers, philippi;
	
	protected Superfamily superfamily;
	protected Family family;
	protected Genus genus;
	protected Species species;
	protected Subspecies subspecies;

	@Before
	public void populateDatabase() {
		
		swainson = new Taxonomer();
		swainson.setName("William John");
		swainson.setSurname("Swainson");
		swainson = service.saveTaxonomer(swainson);
		
		albers = new Taxonomer();
		albers.setName("Johann Christian");
		albers.setSurname("Albers");
		albers = service.saveTaxonomer(albers);
		
		philippi = new Taxonomer();
		philippi.setName("");
		philippi.setSurname("Philippi");
		philippi = service.saveTaxonomer(philippi);
		
		superfamily = new Superfamily();
		superfamily.setName("achatinoidea");
		superfamily.getTaxonomers().add(swainson);
		superfamily.setTaxonomyYear(1840);
		superfamily = service.saveSuperfamily(superfamily);
		
		family = new Family();
		family.setSuperfamily(superfamily);
		family.setName("achatinidae");
		family.getTaxonomers().add(swainson);
		family.setTaxonomyYear(1840);
		family = service.saveFamily(family);
		
		genus = new Genus();
		genus.setFamily(family);
		genus.setName("archachatina");
		genus.getTaxonomers().add(albers);
		genus.setTaxonomyYear(1850);
		genus = service.saveGenus(genus);
		
		species = new Species();
		species.setGenus(genus);
		species.setName("marginata");
		species.getTaxonomers().add(swainson);
		species.setTaxonomyYear(1821);
		species = service.saveSpecies(species);
		
		subspecies = new Subspecies();
		subspecies.setSpecies(species);
		subspecies.setName("depravata");
		subspecies.getTaxonomers().add(philippi);
		subspecies.setTaxonomyYear(1849);
		subspecies.setMinHeight(110);
		subspecies.setMaxHeight(110);
		subspecies.setMinWidth(60);
		subspecies.setMaxWidth(60);
		subspecies = service.saveSubspecies(subspecies);
		
	}

	@After
	public void depopulateDatabase() {
		
		// cascade delete must be used
		service.deleteSuperfamily(superfamily.getSuperfamilyId());

		service.deleteTaxonomer(swainson.getTaxonomerId());
		service.deleteTaxonomer(albers.getTaxonomerId());
		service.deleteTaxonomer(philippi.getTaxonomerId());
		
	}
	
}
