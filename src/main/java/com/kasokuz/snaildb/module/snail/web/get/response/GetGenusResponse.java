package com.kasokuz.snaildb.module.snail.web.get.response;

import java.util.ArrayList;
import java.util.List;

public class GetGenusResponse extends CommonResponse {
	
	public List<Child> species = new ArrayList<>();
	
	public GetGenusResponse(com.kasokuz.snaildb.module.snail.entity.Genus genus) {
		id = genus.getGenusId();
		name = genus.getName();
		taxonomer = new Taxonomer(genus.getTaxonomer());
		taxonomyYear = genus.getTaxonomyYear();
		for(com.kasokuz.snaildb.module.snail.entity.Species species : genus.getSpecies()) {
			this.species.add(new Child(species.getSpeciesId(), species.getName(), species.getTaxonomer(), species.getTaxonomyYear()));
		}
	}
	
	public static GetGenusResponse from(com.kasokuz.snaildb.module.snail.entity.Genus genus) {
		if(genus == null) return null;
		else return new GetGenusResponse(genus);
	}

}
