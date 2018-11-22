package com.kasokuz.snaildb.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.kasokuz.snaildb.utils.IdNameInterface;

@Entity
@Table(name = "snail_genus")
public class Genus implements IdNameInterface {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer genusId;
	
	@ManyToOne
	@JoinColumn(name = "family_id")
	private Family family;
	
	@ManyToOne
	@JoinColumn(name = "subfamily_id")
	private Subfamily subfamily;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "genus")
	private List<Species> species;
	
	@Column(nullable = false)
	private String name;
	
	@ManyToMany
	@JoinTable(name = "snail_genus_taxonomer", joinColumns = @JoinColumn(name = "genus_id"), inverseJoinColumns = @JoinColumn(name = "taxonomer_id"))
	private List<Taxonomer> taxonomers = new ArrayList<>();
	
	@Column(nullable = false)
	private Integer taxonomyYear;
	
	public Genus() {}
	
	public Genus(Family family, Subfamily subfamily, String name, List<Taxonomer> taxonomers, Integer taxonomyYear) {
		this.family = family;
		this.subfamily = subfamily;
		this.name = name;
		this.taxonomers = taxonomers;
		this.taxonomyYear = taxonomyYear;
	}

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

	public Subfamily getSubfamily() {
		return subfamily;
	}

	public void setSubfamily(Subfamily subfamily) {
		this.subfamily = subfamily;
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
	
	public boolean isExtinct() {
		for(Species species : this.species) {
			if(!species.getExtinct()) return false;
		}
		return true;
	}

}
