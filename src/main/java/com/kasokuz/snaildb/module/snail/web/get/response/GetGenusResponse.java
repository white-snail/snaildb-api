package com.kasokuz.snaildb.module.snail.web.get.response;

import java.util.ArrayList;
import java.util.List;

public class GetGenusResponse extends CommonResponse {
	
	public final List<Child> species = new ArrayList<>();
	
	public GetGenusResponse(com.kasokuz.snaildb.module.snail.dto.Genus genus) {
		super(genus.getGenusId(), genus.getName(), genus.getTaxonomer(), genus.getTaxonomyYear());
		for(com.kasokuz.snaildb.module.snail.dto.Species species : genus.getSpecies()) {
			this.species.add(new Child(species.getSpeciesId(), species.getName(), species.getTaxonomer(), species.getTaxonomyYear()));
		}
	}
	
	public static GetGenusResponse from(com.kasokuz.snaildb.module.snail.dto.Genus genus) {
		if(genus == null) return null;
		else return new GetGenusResponse(genus);
	}

}
