package com.kasokuz.snaildb.controller.get.response;

import com.kasokuz.snaildb.domain.Species;

public class GetRandomSpeciesResponse {
	
	public Integer id;
	
	public String name;
	
	public String genus, family, superfamily;
	
	public GetRandomSpeciesResponse(Species species) {
		id = species.getSpeciesId();
		name = species.getName();
		genus = species.getGenus().getName();
		family = species.getGenus().getFamily().getName();
		superfamily = species.getGenus().getFamily().getSuperfamily().getName();
	}

}
