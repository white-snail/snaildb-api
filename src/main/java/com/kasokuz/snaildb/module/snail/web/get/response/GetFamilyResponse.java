package com.kasokuz.snaildb.module.snail.web.get.response;

import java.util.ArrayList;
import java.util.List;

public class GetFamilyResponse extends CommonResponse {

	public final List<Child> genuses = new ArrayList<>();
	
	public GetFamilyResponse(com.kasokuz.snaildb.module.snail.domain.Family family) {
		super(family.getFamilyId(), family.getName(), family.getTaxonomers(), family.getTaxonomyYear());
		for(com.kasokuz.snaildb.module.snail.domain.Genus genus : family.getGenuses()) {
			genuses.add(new Child(genus.getGenusId(), genus.getName(), genus.getTaxonomers(), genus.getTaxonomyYear()));
		}
	}
	
	public static GetFamilyResponse from(com.kasokuz.snaildb.module.snail.domain.Family family) {
		if(family == null) return null;
		else return new GetFamilyResponse(family);
	}
	
}
