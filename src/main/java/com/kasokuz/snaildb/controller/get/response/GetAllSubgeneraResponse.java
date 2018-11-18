package com.kasokuz.snaildb.controller.get.response;

import com.kasokuz.snaildb.domain.Subgenus;

public class GetAllSubgeneraResponse {
	
	public final Integer id;
	
	public final String name;
	
	public GetAllSubgeneraResponse(Subgenus subgenus) {
		this.id = subgenus.getSubgenusId();
		this.name = subgenus.getName();
	}

}
