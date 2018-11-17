package com.kasokuz.snaildb.controller.get.response;

import java.util.ArrayList;
import java.util.List;

import com.kasokuz.snaildb.domain.Genus;
import com.kasokuz.snaildb.domain.Subfamily;

public class GetFamilyResponse extends CommonResponse {
	
	public final Integer superfamilyId;

	public final List<Child> subfamilies = new ArrayList<>();
	
	public final List<GenusChild> genera = new ArrayList<>();
	
	public GetFamilyResponse(com.kasokuz.snaildb.domain.Family family) {
		super(family.getFamilyId(), family.getName(), family.getTaxonomers(), family.getTaxonomyYear());
		this.superfamilyId = family.getSuperfamily().getSuperfamilyId();
		for(com.kasokuz.snaildb.domain.Genus genus : family.getGenuses()) {
			if(genus.getSubfamily() != null) {
				Subfamily subfamily = genus.getSubfamily();
				boolean contains = false;
				for(Child child : this.subfamilies) {
					if(child.id == subfamily.getSubfamilyId()) {
						contains = true;
						break;
					}
				}
				if(!contains) this.subfamilies.add(new Child(subfamily.getSubfamilyId(), subfamily.getName(), subfamily.getTaxonomers(), subfamily.getTaxonomyYear()));
			}
			this.genera.add(new GenusChild(genus));
		}
	}
	
	public static GetFamilyResponse from(com.kasokuz.snaildb.domain.Family family) {
		if(family == null) return null;
		else return new GetFamilyResponse(family);
	}
	
	public static class GenusChild extends Child {
		
		public final Integer subfamily;
		
		public final Boolean extinct;
		
		public GenusChild(Genus genus) {
			super(genus.getGenusId(), genus.getName(), genus.getTaxonomers(), genus.getTaxonomyYear());
			if(genus.getSubfamily() != null) this.subfamily = genus.getSubfamily().getSubfamilyId();
			else this.subfamily = null;
			this.extinct = genus.isExtinct();
		}
		
	}
	
}
