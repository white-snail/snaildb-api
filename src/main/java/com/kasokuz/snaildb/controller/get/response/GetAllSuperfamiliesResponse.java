package com.kasokuz.snaildb.controller.get.response;

import java.util.ArrayList;
import java.util.List;

import com.kasokuz.snaildb.domain.Superfamily;

public class GetAllSuperfamiliesResponse {

	public final Integer id;
	
	public final String name;
	
	public final List<Taxonomer> taxonomers = new ArrayList<>();
	
	public final Integer taxonomyYear;
	
	public final Boolean complete;
	
	public final String type;
	
	public GetAllSuperfamiliesResponse(Superfamily superfamily) {
		this.id = superfamily.getSuperfamilyId();
		this.name = superfamily.getName();
		for(com.kasokuz.snaildb.domain.Taxonomer taxonomer : superfamily.getTaxonomers()) this.taxonomers.add(new Taxonomer(taxonomer));
		this.taxonomyYear = superfamily.getTaxonomyYear();
		this.complete = superfamily.getComplete();
		this.type = superfamily.getType();
	}
	
	public static class Taxonomer {
		
		public final Integer id;
		
		public final String surname;
		
		public Taxonomer(com.kasokuz.snaildb.domain.Taxonomer taxonomer) {
			this.id = taxonomer.getTaxonomerId();
			this.surname = taxonomer.getSurname();
		}
		
	}
	
}
