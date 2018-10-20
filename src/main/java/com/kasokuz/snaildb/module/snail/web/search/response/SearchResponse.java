package com.kasokuz.snaildb.module.snail.web.search.response;

import java.util.ArrayList;
import java.util.List;

import com.kasokuz.snaildb.module.snail.entity.*;
import com.kasokuz.snaildb.module.snail.utils.IdNameInterface;

public class SearchResponse {

	public final List<Child> superfamilies = new ArrayList<>();
	public final List<Child> families = new ArrayList<>();
	public final List<Child> genuses = new ArrayList<>();
	public final List<Child> species = new ArrayList<>();
	public final List<Child> subspecies = new ArrayList<>();
	
	public SearchResponse(Iterable<Superfamily> superfamilies, Iterable<Family> families, Iterable<Genus> genuses, Iterable<Species> species_, Iterable<Subspecies> subspecies_) {
		for(Superfamily superfamily : superfamilies) this.superfamilies.add(new Child(superfamily));
		for(Family family : families) this.families.add(new Child(family));
		for(Genus genus : genuses) this.genuses.add(new Child(genus));
		for(Species species : species_) this.species.add(new Child(species));
		for(Subspecies subspecies : subspecies_) this.subspecies.add(new Child(subspecies));
	}
	
	public static class Child {
		
		public final Integer id;
		
		public final String name;
		
		public Child(IdNameInterface idNameInterface) {
			this.id = idNameInterface.getId();
			this.name = idNameInterface.getName();
		}
		
	}

}
