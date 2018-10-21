package com.kasokuz.snaildb.module.snail.web.get.response;

import java.util.ArrayList;
import java.util.List;

public class GetSpeciesResponse extends CommonResponse {
	
	public final List<GetSubspeciesResponse> subspecies = new ArrayList<>();
	
	public GetSpeciesResponse(com.kasokuz.snaildb.module.snail.dto.Species species) {
		super(species.getSpeciesId(), species.getName(), species.getTaxonomer(), species.getTaxonomyYear());
		for(com.kasokuz.snaildb.module.snail.dto.Subspecies subspecies : species.getSubspecies()) {
			this.subspecies.add(new GetSubspeciesResponse(subspecies));
		}
	}
	
	public static GetSpeciesResponse from(com.kasokuz.snaildb.module.snail.dto.Species species) {
		if(species == null) return null;
		else return new GetSpeciesResponse(species);
	}

}
