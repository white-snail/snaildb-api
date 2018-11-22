package com.kasokuz.snaildb.controller.get.response;

import java.util.ArrayList;
import java.util.List;

import com.kasokuz.snaildb.domain.Family;

public class GetSuperfamilyResponse extends CommonResponse {
	
	public final Boolean complete;
	
	public final String type;
	
	public final Boolean airBreathing;
	
	public final List<FamilyChild> families = new ArrayList<>();
	
	public GetSuperfamilyResponse(com.kasokuz.snaildb.domain.Superfamily superfamily) {
		super(superfamily.getSuperfamilyId(), superfamily.getName(), superfamily.getTaxonomers(), superfamily.getTaxonomyYear());
		this.complete = superfamily.getComplete();
		this.type = superfamily.getType();
		this.airBreathing = superfamily.getAirBreathing();
		for(com.kasokuz.snaildb.domain.Family family : superfamily.getFamilies()) {
			families.add(new FamilyChild(family));
		}
	}
	
	public static GetSuperfamilyResponse from(com.kasokuz.snaildb.domain.Superfamily superfamily) {
		if(superfamily == null) return null;
		else return new GetSuperfamilyResponse(superfamily);
	}
	
	public static class FamilyChild extends Child {
		
		public final Boolean extinct;
		
		public FamilyChild(Family family) {
			super(family.getFamilyId(), family.getName(), family.getTaxonomers(), family.getTaxonomyYear());
			this.extinct = family.isExtinct();
		}
		
	}

}
