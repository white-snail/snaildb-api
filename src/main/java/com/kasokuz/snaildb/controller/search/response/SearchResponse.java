package com.kasokuz.snaildb.controller.search.response;

import java.util.ArrayList;
import java.util.List;

import com.kasokuz.snaildb.utils.IdNameInterface;

public class SearchResponse {

	public final List<Child> superfamilies = new ArrayList<>();
	public final List<Family> families = new ArrayList<>();
	public final List<Genus> genera = new ArrayList<>();
	public final List<Species> species = new ArrayList<>();
	public final List<Subspecies> subspecies = new ArrayList<>();
	
	public static class Child {
		
		public final Integer id;
		
		public final String name;
		
		public Child(IdNameInterface idNameInterface) {
			this.id = idNameInterface.getId();
			this.name = idNameInterface.getName();
		}
		
	}
	
	public static class Family extends Child {
		
		public final String superfamily;
		
		public Family(com.kasokuz.snaildb.domain.Family family) {
			super(family);
			this.superfamily = family.getSuperfamily().getName();
		}
		
	}
	
	public static class Genus extends Child {
		
		public final String superfamily, family;
		
		public Genus(com.kasokuz.snaildb.domain.Genus genus) {
			super(genus);
			this.superfamily = genus.getFamily().getSuperfamily().getName();
			this.family = genus.getFamily().getName();
		}
		
	}
	
	public static class Species extends Child {
		
		public final String superfamily, family, genus;
		
		public Species(com.kasokuz.snaildb.domain.Species species) {
			super(species);
			this.superfamily = species.getGenus().getFamily().getSuperfamily().getName();
			this.family = species.getGenus().getFamily().getName();
			this.genus = species.getGenus().getName();
		}
		
	}
	
	public static class Subspecies extends Child {
		
		public final String superfamily, family, genus, species;
		
		public Subspecies(com.kasokuz.snaildb.domain.Subspecies subspecies) {
			super(subspecies);
			this.superfamily = subspecies.getSpecies().getGenus().getFamily().getSuperfamily().getName();
			this.family = subspecies.getSpecies().getGenus().getFamily().getName();
			this.genus = subspecies.getSpecies().getGenus().getName();
			this.species = subspecies.getSpecies().getName();
		}
	}

}
