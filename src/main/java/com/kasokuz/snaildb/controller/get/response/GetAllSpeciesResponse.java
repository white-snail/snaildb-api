package com.kasokuz.snaildb.controller.get.response;

import com.kasokuz.snaildb.domain.Species;

public class GetAllSpeciesResponse {

	public final Integer id;
	
	public final String name;
	
	public GetAllSpeciesResponse(Species species) {
		this.id = species.getSpeciesId();
		this.name = species.getName();
	}
	
}
