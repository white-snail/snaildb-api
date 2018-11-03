package com.kasokuz.snaildb.module.snail.web.get.response;

import com.kasokuz.snaildb.module.snail.domain.Genus;

public class GetAllGenusesResponse {

	public final Integer id;
	
	public final String name;
	
	public GetAllGenusesResponse(Genus genus) {
		this.id = genus.getGenusId();
		this.name = genus.getName();
	}
	
}
