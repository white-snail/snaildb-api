package com.kasokuz.snaildb.module.snail.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kasokuz.snaildb.module.snail.utils.NameMapper;

@Entity
@Table(name = "snail_genus")
public class Genus implements NameMapper.Mappable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer genusId;
	
	@ManyToOne
	@JoinColumn(name = "family_id")
	private Family family;
	
	@OneToMany(mappedBy = "genus")
	private List<Species> species;
	
	@Column(nullable = false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "taxonomer_id")
	private Taxonomer taxonomer;
	
	@Column(nullable = false)
	private Integer taxonomyYear;

	@JsonProperty("id")
	public Integer getGenusId() {
		return genusId;
	}

	public void setGenusId(Integer genusId) {
		this.genusId = genusId;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	@JsonIgnore
	public List<Species> getSpecies() {
		return species;
	}

	public void setSpecies(List<Species> species) {
		this.species = species;
	}

	@Override
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
