package com.kasokuz.snaildb.module.snail.web.get.response;

public class CommonResponse {

	public Integer id;
	
	public String name;
	
	public Taxonomer taxonomer;
	
	public Integer taxonomyYear;
	
	public static class Taxonomer {
		
		public Integer id;
		
		public String surname;
		
		public Taxonomer(com.kasokuz.snaildb.module.snail.entity.Taxonomer taxonomer) {
			id = taxonomer.getTaxonomerId();
			surname = taxonomer.getSurname();
		}
		
	}
	
	public static class Child {
		
		public Integer id;
		
		public String name;
		
		public Taxonomer taxonomer;
		
		public Integer taxonomerYear;
		
		public Child(Integer id, String name, com.kasokuz.snaildb.module.snail.entity.Taxonomer taxonomer, Integer taxonomerYear) {
			this.id = id;
			this.name = name;
			this.taxonomer = new Taxonomer(taxonomer);
			this.taxonomerYear = taxonomerYear;
		}
		
	}
	
}
