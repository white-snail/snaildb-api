package com.kasokuz.snaildb.module.snail.web.get.response;

import com.kasokuz.snaildb.module.snail.domain.Species;

public class GetAllSpeciesResponse {

	public final Integer id;
	
	public final String name;
	
	public GetAllSpeciesResponse(Species species) {
		this.id = species.getSpeciesId();
		this.name = species.getName();
	}
	
}
