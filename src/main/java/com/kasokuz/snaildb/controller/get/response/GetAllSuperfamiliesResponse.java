package com.kasokuz.snaildb.controller.get.response;

import com.kasokuz.snaildb.domain.Superfamily;

public class GetAllSuperfamiliesResponse {

	public final Integer id;
	
	public final String name;
	
	public GetAllSuperfamiliesResponse(Superfamily superfamily) {
		this.id = superfamily.getSuperfamilyId();
		this.name = superfamily.getName();
	}
	
}
