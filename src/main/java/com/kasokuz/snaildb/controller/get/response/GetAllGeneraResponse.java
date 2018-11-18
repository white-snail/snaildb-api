package com.kasokuz.snaildb.controller.get.response;

import com.kasokuz.snaildb.domain.Genus;

public class GetAllGeneraResponse {

	public final Integer id;
	
	public final String name;
	
	public GetAllGeneraResponse(Genus genus) {
		this.id = genus.getGenusId();
		this.name = genus.getName();
	}
	
}
