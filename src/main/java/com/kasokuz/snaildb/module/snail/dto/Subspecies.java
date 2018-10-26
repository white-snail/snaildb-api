package com.kasokuz.snaildb.module.snail.dto;

import javax.persistence.*;

import com.kasokuz.snaildb.module.snail.utils.IdNameInterface;

@Entity
@Table(name = "snail_subspecies")
public class Subspecies implements IdNameInterface {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer subspeciesId;
	
	@ManyToOne
	@JoinColumn(name = "species_id")
	private Species species;
	
	@Column(nullable = false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "taxonomer_id")
	private Taxonomer taxonomer;
	
	@Column(nullable = false)
	private Integer taxonomyYear;
	
	@Column(nullable = false)
	private Integer minHeight;
	
	@Column(nullable = false)
	private Integer maxHeight;
	
	@Column(nullable = false)
	private Integer minWidth;
	
	@Column(nullable = false)
	private Integer maxWidth;
	
	@Column(nullable = false)
	private Boolean extinct = false;
	
	@Column(nullable = false)
	private Boolean viviparous = false;
	
	@Override
	public Integer getId() {
		return subspeciesId;
	}
	
	public Integer getSubspeciesId() {
		return subspeciesId;
	}

	public void setSubspeciesId(Integer subspeciesId) {
		this.subspeciesId = subspeciesId;
	}

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
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

	public Integer getMinHeight() {
		return minHeight;
	}

	public void setMinHeight(Integer minHeight) {
		this.minHeight = minHeight;
	}

	public Integer getMaxHeight() {
		return maxHeight;
	}

	public void setMaxHeight(Integer maxHeight) {
		this.maxHeight = maxHeight;
	}

	public Integer getMinWidth() {
		return minWidth;
	}

	public void setMinWidth(Integer minWidth) {
		this.minWidth = minWidth;
	}

	public Integer getMaxWidth() {
		return maxWidth;
	}

	public void setMaxWidth(Integer maxWidth) {
		this.maxWidth = maxWidth;
	}

	public Boolean getExtinct() {
		return extinct;
	}

	public void setExtinct(Boolean extinct) {
		this.extinct = extinct;
	}

	public Boolean getViviparous() {
		return viviparous;
	}

	public void setViviparous(Boolean viviparous) {
		this.viviparous = viviparous;
	}

}
