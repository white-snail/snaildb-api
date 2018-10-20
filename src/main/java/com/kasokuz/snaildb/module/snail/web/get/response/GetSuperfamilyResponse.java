package com.kasokuz.snaildb.module.snail.web.get.response;

import java.util.ArrayList;
import java.util.List;

public class GetSuperfamilyResponse extends CommonResponse {
	
	public List<Child> families = new ArrayList<>();
	
	public GetSuperfamilyResponse(com.kasokuz.snaildb.module.snail.entity.Superfamily superfamily) {
		id = superfamily.getSuperfamilyId();
		name = superfamily.getName();
		taxonomer = new Taxonomer(superfamily.getTaxonomer());
		taxonomyYear = superfamily.getTaxonomyYear();
		for(com.kasokuz.snaildb.module.snail.entity.Family family : superfamily.getFamilies()) {
			families.add(new Child(family.getFamilyId(), family.getName(), family.getTaxonomer(), family.getTaxonomyYear()));
		}
	}
	
	public static GetSuperfamilyResponse from(com.kasokuz.snaildb.module.snail.entity.Superfamily superfamily) {
		if(superfamily == null) return null;
		else return new GetSuperfamilyResponse(superfamily);
	}

}
