package com.kasokuz.snaildb.module.snail.web.get.response;

import java.util.ArrayList;
import java.util.List;

public class GetSpeciesResponse extends CommonResponse {
	
	public final List<GetSubspeciesResponse> subspecies = new ArrayList<>();
	
	public GetSpeciesResponse(com.kasokuz.snaildb.module.snail.domain.Species species) {
		super(species.getSpeciesId(), species.getName(), species.getTaxonomers(), species.getTaxonomyYear());
		for(com.kasokuz.snaildb.module.snail.domain.Subspecies subspecies : species.getSubspecies()) {
			this.subspecies.add(new GetSubspeciesResponse(subspecies));
		}
	}
	
	public static GetSpeciesResponse from(com.kasokuz.snaildb.module.snail.domain.Species species) {
		if(species == null) return null;
		else return new GetSpeciesResponse(species);
	}

}
