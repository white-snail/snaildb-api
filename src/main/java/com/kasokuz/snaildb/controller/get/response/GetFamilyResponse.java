package com.kasokuz.snaildb.controller.get.response;

import java.util.ArrayList;
import java.util.List;

import com.kasokuz.snaildb.domain.Genus;

public class GetFamilyResponse extends CommonResponse {
	
	public final Integer superfamilyId;

	public final List<Child> genuses = new ArrayList<>();
	
	public GetFamilyResponse(com.kasokuz.snaildb.domain.Family family) {
		super(family.getFamilyId(), family.getName(), family.getTaxonomers(), family.getTaxonomyYear());
		this.superfamilyId = family.getSuperfamily().getSuperfamilyId();
		for(com.kasokuz.snaildb.domain.Genus genus : family.getGenuses()) {
			genuses.add(new GenusChild(genus));
		}
	}
	
	public static GetFamilyResponse from(com.kasokuz.snaildb.domain.Family family) {
		if(family == null) return null;
		else return new GetFamilyResponse(family);
	}
	
	public static class GenusChild extends Child {
		
		public final Boolean extinct;
		
		public GenusChild(Genus genus) {
			super(genus.getGenusId(), genus.getName(), genus.getTaxonomers(), genus.getTaxonomyYear());
			this.extinct = genus.isExtinct();
		}
		
	}
	
}
