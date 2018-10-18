package com.kasokuz.snaildb.module.snail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.kasokuz.snaildb.module.snail.entity.*;
import com.kasokuz.snaildb.module.snail.service.SnailService;

@RunWith(SpringRunner.class)
public class GetTest {
	
	@Autowired
	private SnailService service;
	
	private Superfamily superfamily;
	private Family family;
	private Genus genus;
	private Species species;
	private Subspecies subspecies;
	
	@Before
	public void populateDatabase() {
		
		superfamily = new Superfamily();
		superfamily.setName("achatinoidea");
		superfamily = service.saveSuperfamily(superfamily);
		
		family = new Family();
		family.setSuperfamily(superfamily);
		family.setName("achatinidae");
		family = service.saveFamily(family);
		
		genus = new Genus();
		genus.setFamily(family);
		genus.setName("achatina");
		genus = service.saveGenus(genus);
		
		species = new Species();
		species.setGenus(genus);
		species.setName("achatina");
		species = service.saveSpecies(species);
		
		subspecies = new Subspecies();
		subspecies.setSpecies(species);
		subspecies.setName("depravata");
		subspecies = service.saveSubspecies(subspecies);
		
	}
	
	@Test
	public void testGetSuperfamily() {
		
	}
	
	@After
	public void depopulateDatabase() {
		
	}

}
