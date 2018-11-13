package com.kasokuz.snaildb.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.kasokuz.snaildb.utils.IdNameInterface;

@Entity
@Table(name = "snail_species")
public class Species implements IdNameInterface {
	
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
	
	@ManyToMany
	@JoinTable(name = "snail_species_taxonomer", joinColumns = @JoinColumn(name = "species_id"), inverseJoinColumns = @JoinColumn(name = "taxonomer_id"))
	private List<Taxonomer> taxonomers = new ArrayList<>();
	
	@Column(nullable = false)
	private Integer taxonomyYear;
	
	@Column(nullable = false)
	private Boolean viviparous = false;

	@Column(nullable = false)
	private Boolean extinct = false;
	
	public Species() {}

	public Species(Genus genus, String name, List<Taxonomer> taxonomers, Integer taxonomyYear, Boolean viviparous, Boolean extinct) {
		this.genus = genus;
		this.name = name;
		this.taxonomers = taxonomers;
		this.taxonomyYear = taxonomyYear;
		this.viviparous = viviparous;
		this.extinct = extinct;
	}

	@Override
	public Integer getId() {
		return speciesId;
	}
	
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

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Taxonomer> getTaxonomers() {
		return taxonomers;
	}

	public void setTaxonomers(List<Taxonomer> taxonomers) {
		this.taxonomers = taxonomers;
	}

	public Integer getTaxonomyYear() {
		return taxonomyYear;
	}

	public void setTaxonomyYear(Integer taxonomyYear) {
		this.taxonomyYear = taxonomyYear;
	}

	public Boolean getViviparous() {
		return viviparous;
	}

	public void setViviparous(Boolean viviparous) {
		this.viviparous = viviparous;
	}

	public Boolean getExtinct() {
		return extinct;
	}

	public void setExtinct(Boolean extinct) {
		this.extinct = extinct;
	}

}
