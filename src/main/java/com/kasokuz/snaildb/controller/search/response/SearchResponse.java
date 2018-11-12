package com.kasokuz.snaildb.controller.search.response;

import java.util.ArrayList;
import java.util.List;

import com.kasokuz.snaildb.utils.IdNameInterface;

public class SearchResponse {

	public final List<Child> superfamilies = new ArrayList<>();
	public final List<Child> families = new ArrayList<>();
	public final List<Child> genuses = new ArrayList<>();
	public final List<Child> species = new ArrayList<>();
	public final List<Child> subspecies = new ArrayList<>();
	
	public static class Child {
		
		public final Integer id;
		
		public final String name;
		
		public Child(IdNameInterface idNameInterface) {
			this.id = idNameInterface.getId();
			this.name = idNameInterface.getName();
		}
		
	}
	
	public static class Species extends Child {
		
		public final String genus;
		
		public Species(com.kasokuz.snaildb.domain.Species species) {
			super(species);
			this.genus = species.getGenus().getName();
		}
		
	}
	
	public static class Subspecies extends Child {
		
		public final String genus, species;
		
		public Subspecies(com.kasokuz.snaildb.domain.Subspecies subspecies) {
			super(subspecies);
			this.genus = subspecies.getSpecies().getGenus().getName();
			this.species = subspecies.getSpecies().getName();
		}
	}

}
