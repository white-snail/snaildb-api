package com.kasokuz.snaildb.module.snail.web.get.response;

import java.util.ArrayList;
import java.util.List;

public abstract class CommonResponse {

	public Integer id;
	
	public String name;
	
	public List<Taxonomer> taxonomers = new ArrayList<>();
	
	public Integer taxonomyYear;
	
	public CommonResponse(Integer id, String name, List<com.kasokuz.snaildb.module.snail.dto.Taxonomer> taxonomers, Integer taxonomyYear) {
		this.id = id;
		this.name = name;
		for(com.kasokuz.snaildb.module.snail.dto.Taxonomer taxonomer : taxonomers) this.taxonomers.add(new Taxonomer(taxonomer));
		this.taxonomyYear = taxonomyYear;
	}
	
	public static class Taxonomer {
		
		public final Integer id;
		
		public final String surname;
		
		public Taxonomer(com.kasokuz.snaildb.module.snail.dto.Taxonomer taxonomer) {
			id = taxonomer.getTaxonomerId();
			surname = taxonomer.getSurname();
		}
		
	}
	
	public static class Child {
		
		public final Integer id;
		
		public final String name;
		
		public final List<Taxonomer> taxonomers = new ArrayList<>();
		
		public final Integer taxonomyYear;
		
		public Child(Integer id, String name, List<com.kasokuz.snaildb.module.snail.dto.Taxonomer> taxonomers, Integer taxonomyYear) {
			this.id = id;
			this.name = name;
			for(com.kasokuz.snaildb.module.snail.dto.Taxonomer taxonomer : taxonomers) this.taxonomers.add(new Taxonomer(taxonomer));
			this.taxonomyYear = taxonomyYear;
		}
		
	}
	
}
