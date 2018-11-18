package com.kasokuz.snaildb.controller.get.response;

import java.util.ArrayList;
import java.util.List;

import com.kasokuz.snaildb.domain.Species;
import com.kasokuz.snaildb.domain.Subgenus;

public class GetGenusResponse extends CommonResponse {
	
	public final Integer familyId, subfamilyId;
	
	public final List<Child> subgenera = new ArrayList<>();
	
	public final List<SpeciesChild> species = new ArrayList<>();
	
	public GetGenusResponse(com.kasokuz.snaildb.domain.Genus genus) {
		super(genus.getGenusId(), genus.getName(), genus.getTaxonomers(), genus.getTaxonomyYear());
		this.familyId = genus.getFamily().getFamilyId();
		if(genus.getSubfamily() != null) this.subfamilyId = genus.getSubfamily().getSubfamilyId();
		else this.subfamilyId = null;
		for(com.kasokuz.snaildb.domain.Species species : genus.getSpecies()) {
			if(species.getSubgenus() != null) {
				Subgenus subgenus = species.getSubgenus();
				boolean contains = false;
				for(Child child : this.subgenera) {
					if(child.id == subgenus.getSubgenusId()) {
						contains = true;
						break;
					}
				}
				if(!contains) this.subgenera.add(new Child(subgenus.getSubgenusId(), subgenus.getName(), subgenus.getTaxonomers(), subgenus.getTaxonomyYear()));
			}
			this.species.add(new SpeciesChild(species));
		}
	}
	
	public static GetGenusResponse from(com.kasokuz.snaildb.domain.Genus genus) {
		if(genus == null) return null;
		else return new GetGenusResponse(genus);
	}
	
	public static class SpeciesChild extends Child {
		
		public final Integer subgenus;
		
		public final Boolean extinct;
		
		public SpeciesChild(Species species) {
			super(species.getSpeciesId(), species.getName(), species.getTaxonomers(), species.getTaxonomyYear());
			if(species.getSubgenus() != null) this.subgenus = species.getSubgenus().getSubgenusId();
			else this.subgenus = null;
			this.extinct = species.getExtinct();
		}
		
	}

}
