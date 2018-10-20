package com.kasokuz.snaildb.module.snail.web.get.response;

public abstract class CommonResponse {

	public Integer id;
	
	public String name;
	
	public Taxonomer taxonomer;
	
	public Integer taxonomyYear;
	
	public CommonResponse(Integer id, String name, com.kasokuz.snaildb.module.snail.entity.Taxonomer taxonomer, Integer taxonomyYear) {
		this.id = id;
		this.name = name;
		this.taxonomer = new Taxonomer(taxonomer);
		this.taxonomyYear = taxonomyYear;
	}
	
	public static class Taxonomer {
		
		public final Integer id;
		
		public final String surname;
		
		public Taxonomer(com.kasokuz.snaildb.module.snail.entity.Taxonomer taxonomer) {
			id = taxonomer.getTaxonomerId();
			surname = taxonomer.getSurname();
		}
		
	}
	
	public static class Child {
		
		public final Integer id;
		
		public final String name;
		
		public final Taxonomer taxonomer;
		
		public final Integer taxonomerYear;
		
		public Child(Integer id, String name, com.kasokuz.snaildb.module.snail.entity.Taxonomer taxonomer, Integer taxonomerYear) {
			this.id = id;
			this.name = name;
			this.taxonomer = new Taxonomer(taxonomer);
			this.taxonomerYear = taxonomerYear;
		}
		
	}
	
}
