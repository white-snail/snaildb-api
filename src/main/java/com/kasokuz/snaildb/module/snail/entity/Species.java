package com.kasokuz.snaildb.module.snail.entity;

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
	
	@Column(nullable = false)
	private String name;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
