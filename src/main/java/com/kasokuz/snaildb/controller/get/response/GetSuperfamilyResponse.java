package com.kasokuz.snaildb.controller.get.response;

import java.util.ArrayList;
import java.util.List;

public class GetSuperfamilyResponse extends CommonResponse {
	
	public final Boolean complete;
	
	public final String type;
	
	public final Boolean airBreathing;
	
	public final List<Child> families = new ArrayList<>();
	
	public GetSuperfamilyResponse(com.kasokuz.snaildb.domain.Superfamily superfamily) {
		super(superfamily.getSuperfamilyId(), superfamily.getName(), superfamily.getTaxonomers(), superfamily.getTaxonomyYear());
		this.complete = superfamily.getComplete();
		this.type = superfamily.getType();
		this.airBreathing = superfamily.getAirBreathing();
		for(com.kasokuz.snaildb.domain.Family family : superfamily.getFamilies()) {
			families.add(new Child(family.getFamilyId(), family.getName(), family.getTaxonomers(), family.getTaxonomyYear()));
		}
	}
	
	public static GetSuperfamilyResponse from(com.kasokuz.snaildb.domain.Superfamily superfamily) {
		if(superfamily == null) return null;
		else return new GetSuperfamilyResponse(superfamily);
	}

}
