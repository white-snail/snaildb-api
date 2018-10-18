package com.kasokuz.snaildb.module.snail;

import com.kasokuz.snaildb.module.snail.entity.*;
import com.kasokuz.snaildb.module.snail.service.SnailService;

public abstract class SnailTest {
	
	protected Superfamily superfamily;
	protected Family family;
	protected Genus genus;
	protected Species species;
	protected Subspecies subspecies;

	protected void populate(SnailService service) {
		
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

	protected void depopulate(SnailService service) {
		
		// cascade delete must be used
		service.deleteSuperfamily(superfamily.getSuperfamilyId());
		
	}
	
}
