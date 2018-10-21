package com.kasokuz.snaildb.module.snail.dto;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "snail_taxonomer")
public class Taxonomer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer taxonomerId;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String surname;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "taxonomer")
	private List<Superfamily> superfamilies;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "taxonomer")
	private List<Family> families;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "taxonomer")
	private List<Genus> genuses;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "taxonomer")
	private List<Species> species;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "taxonomer")
	private List<Subspecies> subspecies;
	
	public Integer getTaxonomerId() {
		return taxonomerId;
	}

	public void setTaxonomerId(Integer taxonomerId) {
		this.taxonomerId = taxonomerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Superfamily> getSuperfamilies() {
		return superfamilies;
	}

	public void setSuperfamilies(List<Superfamily> superfamilies) {
		this.superfamilies = superfamilies;
	}

	public List<Family> getFamilies() {
		return families;
	}

	public void setFamilies(List<Family> families) {
		this.families = families;
	}

	public List<Genus> getGenuses() {
		return genuses;
	}

	public void setGenuses(List<Genus> genuses) {
		this.genuses = genuses;
	}

	public List<Species> getSpecies() {
		return species;
	}

	public void setSpecies(List<Species> species) {
		this.species = species;
	}

	public List<Subspecies> getSubspecies() {
		return subspecies;
	}

	public void setSubspecies(List<Subspecies> subspecies) {
		this.subspecies = subspecies;
	}
	
}
