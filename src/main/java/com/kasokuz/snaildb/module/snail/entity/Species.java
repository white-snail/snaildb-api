package com.kasokuz.snaildb.module.snail.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "snail_species")
public class Species {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer speciesId;
	
	@ManyToOne
	@JoinColumn(name = "genus_id")
	private Genus genus;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "species")
	private List<Subspecies> subspecies;
	
	@Column(nullable = false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "taxonomer_id")
	private Taxonomer taxonomer;
	
	@Column(nullable = false)
	private Integer taxonomyYear;

	public Integer getSpeciesId() {
		return speciesId;
	}

	public void setSpeciesId(Integer speciesId) {
		this.speciesId = speciesId;
	}

	public Genus getGenus() {
		return genus;
	}

	public void setGenus(Genus genus) {
		this.genus = genus;
	}

	public List<Subspecies> getSubspecies() {
		return subspecies;
	}

	public void setSubspecies(List<Subspecies> subspecies) {
		this.subspecies = subspecies;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Taxonomer getTaxonomer() {
		return taxonomer;
	}

	public void setTaxonomer(Taxonomer taxonomer) {
		this.taxonomer = taxonomer;
	}

	public Integer getTaxonomyYear() {
		return taxonomyYear;
	}

	public void setTaxonomyYear(Integer taxonomyYear) {
		this.taxonomyYear = taxonomyYear;
	}

}
