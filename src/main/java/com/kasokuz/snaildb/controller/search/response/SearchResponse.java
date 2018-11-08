package com.kasokuz.snaildb.controller.search.response;

import java.util.ArrayList;
import java.util.List;

import com.kasokuz.snaildb.utils.IdNameInterface;

public class SearchResponse {

	public final List<Child> superfamilies = new ArrayList<>();
	public final List<Child> families = new ArrayList<>();
	public final List<Child> genuses = new ArrayList<>();
	public final List<Child> species = new ArrayList<>();
	public final List<Child> subspecies = new ArrayList<>();
	
	public static class Child {
		
		public final Integer id;
		
		public final String name;
		
		public Child(IdNameInterface idNameInterface) {
			this.id = idNameInterface.getId();
			this.name = idNameInterface.getName();
		}
		
	}

}
