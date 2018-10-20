package com.kasokuz.snaildb.module.snail.web.get.response;

import java.util.ArrayList;
import java.util.List;

public class GetSpeciesResponse extends CommonResponse {
	
	public List<Child> subspecies = new ArrayList<>();
	
	public GetSpeciesResponse(com.kasokuz.snaildb.module.snail.entity.Species species) {
		id = species.getSpeciesId();
		name = species.getName();
		taxonomer = new Taxonomer(species.getTaxonomer());
		taxonomyYear = species.getTaxonomyYear();
		for(com.kasokuz.snaildb.module.snail.entity.Subspecies subspecies : species.getSubspecies()) {
			this.subspecies.add(new Child(subspecies.getSubspeciesId(), subspecies.getName(), subspecies.getTaxonomer(), subspecies.getTaxonomyYear()));
		}
	}
	
	public static GetSpeciesResponse from(com.kasokuz.snaildb.module.snail.entity.Species species) {
		if(species == null) return null;
		else return new GetSpeciesResponse(species);
	}

}
