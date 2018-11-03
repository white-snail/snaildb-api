package com.kasokuz.snaildb.module.snail.web.get.response;

import com.kasokuz.snaildb.module.snail.domain.Subspecies;

public class GetAllSubspeciesResponse {
	
	public final Integer id;
	
	public final String name;
	
	public GetAllSubspeciesResponse(Subspecies subspecies) {
		this.id = subspecies.getSubspeciesId();
		this.name = subspecies.getName();
	}

}
