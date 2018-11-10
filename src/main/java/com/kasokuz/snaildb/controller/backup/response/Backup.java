package com.kasokuz.snaildb.controller.backup.response;

import java.util.ArrayList;
import java.util.List;

public class Backup {
	
	public List<Taxonomer> taxonomers = new ArrayList<>();
	
	public List<Superfamily> superfamilies = new ArrayList<>();
	public List<Family> families = new ArrayList<>();
	public List<Genus> genera = new ArrayList<>();
	public List<Species> species = new ArrayList<>();
	public List<Subspecies> subspecies = new ArrayList<>();
	
	public static class Taxonomer {
		
		public Integer id;
		
		public String n, s;
		
		public Taxonomer() {}
		
		public Taxonomer(com.kasokuz.snaildb.domain.Taxonomer taxonomer) {
			this.id = taxonomer.getTaxonomerId();
			this.n = taxonomer.getName();
			this.s = taxonomer.getSurname();
		}
		
	}
	
	public static class Superfamily {
		
		public Integer id;
		
		public String n;
		
		public List<Integer> t = new ArrayList<>();
		
		public Integer y;
		
		public String p;
		
		public Boolean a;
		
		public Superfamily() {}
		
		public Superfamily(com.kasokuz.snaildb.domain.Superfamily superfamily) {
			this.id = superfamily.getSuperfamilyId();
			this.n = superfamily.getName();
			for(com.kasokuz.snaildb.domain.Taxonomer taxonomer : superfamily.getTaxonomers()) this.t.add(taxonomer.getTaxonomerId());
			this.y = superfamily.getTaxonomyYear();
			this.p = superfamily.getType();
			this.a = superfamily.getAirBreathing();
		}
		
	}
	
	public static class Family {
		
		public Integer id, s;
		
		public String n;
		
		public List<Integer> t = new ArrayList<>();
		
		public Integer y;
		
		public Family() {}
		
		public Family(com.kasokuz.snaildb.domain.Family family) {
			this.id = family.getFamilyId();
			this.s = family.getSuperfamily().getSuperfamilyId();
			this.n = family.getName();
			for(com.kasokuz.snaildb.domain.Taxonomer taxonomer : family.getTaxonomers()) this.t.add(taxonomer.getTaxonomerId());
			this.y = family.getTaxonomyYear();
		}
		
	}
	
	public static class Genus {
		
		public Integer id, f;
		
		public String n;
		
		public List<Integer> t = new ArrayList<>();
		
		public Integer y;
		
		public Genus() {}
		
		public Genus(com.kasokuz.snaildb.domain.Genus genus) {
			this.id = genus.getGenusId();
			this.f = genus.getFamily().getFamilyId();
			this.n = genus.getName();
			for(com.kasokuz.snaildb.domain.Taxonomer taxonomer : genus.getTaxonomers()) this.t.add(taxonomer.getTaxonomerId());
			this.y = genus.getTaxonomyYear();
		}
		
	}
	
	public static class Species {
		
		public Integer id, g;
		
		public String n;
		
		public List<Integer> t = new ArrayList<>();
		
		public Integer y;
		
		public Boolean v, e;
		
		public Species() {}
		
		public Species(com.kasokuz.snaildb.domain.Species species) {
			this.id = species.getSpeciesId();
			this.g = species.getGenus().getGenusId();
			this.n = species.getName();
			for(com.kasokuz.snaildb.domain.Taxonomer taxonomer : species.getTaxonomers()) this.t.add(taxonomer.getTaxonomerId());
			this.y = species.getTaxonomyYear();
			this.v = species.getViviparous();
			this.e = species.getExtinct();
		}
		
	}
	
	public static class Subspecies {
		
		public Integer id, s;
		
		public String n;
		
		public List<Integer> t = new ArrayList<>();
		
		public Integer y;
		
		public Integer mnh, mxh, mnw, mxw;
		
		public Integer f;
		
		public String l;
		
		public Subspecies() {}
		
		public Subspecies(com.kasokuz.snaildb.domain.Subspecies subspecies) {
			this.id = subspecies.getSubspeciesId();
			this.s = subspecies.getSpecies().getSpeciesId();
			this.n = subspecies.getName();
			for(com.kasokuz.snaildb.domain.Taxonomer taxonomer : subspecies.getTaxonomers()) this.t.add(taxonomer.getTaxonomerId());
			this.y = subspecies.getTaxonomyYear();
			this.mnh = subspecies.getMinHeight();
			this.mxh = subspecies.getMaxHeight();
			this.mnw = subspecies.getMinWidth();
			this.mxw = subspecies.getMaxWidth();
			this.f = subspecies.getLifespan();
			this.l = subspecies.getLocation();
		}
		
	}

}
