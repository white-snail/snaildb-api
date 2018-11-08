package com.kasokuz.snaildb.controller.get.response;

import java.util.ArrayList;
import java.util.List;

import com.kasokuz.snaildb.domain.Family;
import com.kasokuz.snaildb.domain.Genus;
import com.kasokuz.snaildb.domain.Species;
import com.kasokuz.snaildb.domain.Subspecies;
import com.kasokuz.snaildb.domain.Superfamily;
import com.kasokuz.snaildb.domain.Taxonomer;

public class GetTaxonomerResponse {
	
	public final Integer id;
	
	public final String name, surname;
	
	public final List<Child> superfamilies = new ArrayList<>();
	public final List<Child> families = new ArrayList<>();
	public final List<Child> genuses = new ArrayList<>();
	public final List<Child> species = new ArrayList<>();
	public final List<Child> subspecies = new ArrayList<>();
	
	public GetTaxonomerResponse(Taxonomer taxonomer) {
		this.id = taxonomer.getTaxonomerId();
		this.name = taxonomer.getName();
		this.surname = taxonomer.getSurname();
		for(Superfamily superfamily : taxonomer.getSuperfamilies()) this.superfamilies.add(new Child(superfamily.getSuperfamilyId(), superfamily.getName(), superfamily.getTaxonomyYear()));
		for(Family family : taxonomer.getFamilies()) this.families.add(new Child(family.getFamilyId(), family.getName(), family.getTaxonomyYear()));
		for(Genus genus : taxonomer.getGenuses()) this.genuses.add(new Child(genus.getGenusId(), genus.getName(), genus.getTaxonomyYear()));
		for(Species species : taxonomer.getSpecies()) this.species.add(new Child(species.getSpeciesId(), species.getName(), species.getTaxonomyYear()));
		for(Subspecies subspecies : taxonomer.getSubspecies()) this.subspecies.add(new Child(subspecies.getSubspeciesId(), subspecies.getName(), subspecies.getTaxonomyYear()));
	}
	
	public static GetTaxonomerResponse from(Taxonomer taxonomer) {
		if(taxonomer == null) return null;
		else return new GetTaxonomerResponse(taxonomer);
	}
	
	public static class Child {
		
		public final Integer id;
		
		public final String name;
		
		public final Integer year;
		
		public Child(Integer id, String name, Integer year) {
			this.id = id;
			this.name = name;
			this.year = year;
		}
		
	}

}
