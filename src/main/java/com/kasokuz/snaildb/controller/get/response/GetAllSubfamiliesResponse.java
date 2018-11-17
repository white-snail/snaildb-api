package com.kasokuz.snaildb.controller.get.response;

import com.kasokuz.snaildb.domain.Subfamily;

public class GetAllSubfamiliesResponse {

	public final Integer id;
	
	public final String name;
	
	public GetAllSubfamiliesResponse(Subfamily subfamily) {
		this.id = subfamily.getId();
		this.name = subfamily.getName();
	}
	
}
