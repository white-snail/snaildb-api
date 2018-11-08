package com.kasokuz.snaildb.controller.get.response;

import java.util.ArrayList;
import java.util.List;

public class GetFamilyResponse extends CommonResponse {

	public final List<Child> genuses = new ArrayList<>();
	
	public GetFamilyResponse(com.kasokuz.snaildb.domain.Family family) {
		super(family.getFamilyId(), family.getName(), family.getTaxonomers(), family.getTaxonomyYear());
		for(com.kasokuz.snaildb.domain.Genus genus : family.getGenuses()) {
			genuses.add(new Child(genus.getGenusId(), genus.getName(), genus.getTaxonomers(), genus.getTaxonomyYear()));
		}
	}
	
	public static GetFamilyResponse from(com.kasokuz.snaildb.domain.Family family) {
		if(family == null) return null;
		else return new GetFamilyResponse(family);
	}
	
}
