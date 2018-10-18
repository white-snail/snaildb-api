package com.kasokuz.snaildb.module.snail.entity;

import javax.persistence.*;

@Entity
@Table(name = "snail_subspecies")
public class Subspecies {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer subspeciesId;
	
	@ManyToOne
	@JoinColumn(name = "species_id")
	private Species species;
	
	@Column(nullable = false)
	private String name;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
