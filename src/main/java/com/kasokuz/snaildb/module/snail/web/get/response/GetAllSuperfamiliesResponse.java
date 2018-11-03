package com.kasokuz.snaildb.module.snail.web.get.response;

import com.kasokuz.snaildb.module.snail.domain.Superfamily;

public class GetAllSuperfamiliesResponse {

	public final Integer id;
	
	public final String name;
	
	public GetAllSuperfamiliesResponse(Superfamily superfamily) {
		this.id = superfamily.getSuperfamilyId();
		this.name = superfamily.getName();
	}
	
}
