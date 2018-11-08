package com.kasokuz.snaildb.controller.get.response;

import com.kasokuz.snaildb.domain.Subspecies;

public class GetAllSubspeciesResponse {
	
	public final Integer id;
	
	public final String name;
	
	public GetAllSubspeciesResponse(Subspecies subspecies) {
		this.id = subspecies.getSubspeciesId();
		this.name = subspecies.getName();
	}

}
