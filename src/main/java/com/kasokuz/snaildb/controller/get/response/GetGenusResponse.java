package com.kasokuz.snaildb.controller.get.response;

import java.util.ArrayList;
import java.util.List;

public class GetGenusResponse extends CommonResponse {
	
	public final Integer familyId;
	
	public final List<Child> species = new ArrayList<>();
	
	public GetGenusResponse(com.kasokuz.snaildb.domain.Genus genus) {
		super(genus.getGenusId(), genus.getName(), genus.getTaxonomers(), genus.getTaxonomyYear());
		this.familyId = genus.getFamily().getFamilyId();
		for(com.kasokuz.snaildb.domain.Species species : genus.getSpecies()) {
			this.species.add(new Child(species.getSpeciesId(), species.getName(), species.getTaxonomers(), species.getTaxonomyYear()));
		}
	}
	
	public static GetGenusResponse from(com.kasokuz.snaildb.domain.Genus genus) {
		if(genus == null) return null;
		else return new GetGenusResponse(genus);
	}

}
