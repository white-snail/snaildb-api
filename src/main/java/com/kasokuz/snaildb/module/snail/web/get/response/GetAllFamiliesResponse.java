package com.kasokuz.snaildb.module.snail.web.get.response;

import com.kasokuz.snaildb.module.snail.domain.Family;

public class GetAllFamiliesResponse {

	public final Integer id;
	
	public final String name;
	
	public GetAllFamiliesResponse(Family family) {
		this.id = family.getFamilyId();
		this.name = family.getName();
	}
	
}
