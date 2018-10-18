package com.kasokuz.snaildb.module.snail.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kasokuz.snaildb.module.snail.utils.NameMapper;

@Entity
@Table(name = "snail_subspecies")
public class Subspecies implements NameMapper.Mappable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer subspeciesId;
	
	@ManyToOne
	@JoinColumn(name = "species_id")
	private Species species;
	
	@Column(nullable = false)
	private String name;

	@JsonProperty("id")
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

}
