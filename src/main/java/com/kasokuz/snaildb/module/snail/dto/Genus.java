package com.kasokuz.snaildb.module.snail.dto;

import java.util.List;

import javax.persistence.*;

import com.kasokuz.snaildb.module.snail.utils.IdNameInterface;

@Entity
@Table(name = "snail_genus")
public class Genus implements IdNameInterface {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer genusId;
	
	@ManyToOne
	@JoinColumn(name = "family_id")
	private Family family;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "genus")
	private List<Species> species;
	
	@Column(nullable = false)
	private String name;
	
	@ManyToMany
	@JoinTable(name = "snail_genus_taxonomer", joinColumns = @JoinColumn(name = "genus_id"), inverseJoinColumns = @JoinColumn(name = "taxonomer_id"))
	private List<Taxonomer> taxonomers;
	
	@Column(nullable = false)
	private Integer taxonomyYear;
	
	@Override
	public Integer getId() {
		return genusId;
	}
	
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

}
