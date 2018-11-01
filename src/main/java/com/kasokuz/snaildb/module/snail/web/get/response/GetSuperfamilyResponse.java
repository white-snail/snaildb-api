package com.kasokuz.snaildb.module.snail.web.get.response;

import java.util.ArrayList;
import java.util.List;

public class GetSuperfamilyResponse extends CommonResponse {
	
	public final List<Child> families = new ArrayList<>();
	
	public GetSuperfamilyResponse(com.kasokuz.snaildb.module.snail.dto.Superfamily superfamily) {
		super(superfamily.getSuperfamilyId(), superfamily.getName(), superfamily.getTaxonomers(), superfamily.getTaxonomyYear());
		for(com.kasokuz.snaildb.module.snail.dto.Family family : superfamily.getFamilies()) {
			families.add(new Child(family.getFamilyId(), family.getName(), family.getTaxonomers(), family.getTaxonomyYear()));
		}
	}
	
	public static GetSuperfamilyResponse from(com.kasokuz.snaildb.module.snail.dto.Superfamily superfamily) {
		if(superfamily == null) return null;
		else return new GetSuperfamilyResponse(superfamily);
	}

}
