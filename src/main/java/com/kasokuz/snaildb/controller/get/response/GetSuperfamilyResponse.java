package com.kasokuz.snaildb.controller.get.response;

import java.util.ArrayList;
import java.util.List;

public class GetSuperfamilyResponse extends CommonResponse {
	
	public final String type;
	
	public final List<Child> families = new ArrayList<>();
	
	public GetSuperfamilyResponse(com.kasokuz.snaildb.domain.Superfamily superfamily) {
		super(superfamily.getSuperfamilyId(), superfamily.getName(), superfamily.getTaxonomers(), superfamily.getTaxonomyYear());
		type = superfamily.getType();
		for(com.kasokuz.snaildb.domain.Family family : superfamily.getFamilies()) {
			families.add(new Child(family.getFamilyId(), family.getName(), family.getTaxonomers(), family.getTaxonomyYear()));
		}
	}
	
	public static GetSuperfamilyResponse from(com.kasokuz.snaildb.domain.Superfamily superfamily) {
		if(superfamily == null) return null;
		else return new GetSuperfamilyResponse(superfamily);
	}

}
