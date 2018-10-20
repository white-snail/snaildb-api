package com.kasokuz.snaildb.module.snail.web.get.response;

import java.util.ArrayList;
import java.util.List;

public class GetFamilyResponse extends CommonResponse {

	public List<Child> genuses = new ArrayList<>();
	
	public GetFamilyResponse(com.kasokuz.snaildb.module.snail.entity.Family family) {
		id = family.getFamilyId();
		name = family.getName();
		taxonomer = new Taxonomer(family.getTaxonomer());
		taxonomyYear = family.getTaxonomyYear();
		for(com.kasokuz.snaildb.module.snail.entity.Genus genus : family.getGenuses()) {
			genuses.add(new Child(genus.getGenusId(), genus.getName(), genus.getTaxonomer(), genus.getTaxonomyYear()));
		}
	}
	
	public static GetFamilyResponse from(com.kasokuz.snaildb.module.snail.entity.Family family) {
		if(family == null) return null;
		else return new GetFamilyResponse(family);
	}
	
}
