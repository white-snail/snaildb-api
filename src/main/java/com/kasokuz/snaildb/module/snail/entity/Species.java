package com.kasokuz.snaildb.module.snail.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kasokuz.snaildb.module.snail.utils.NameMapper;

@Entity
@Table(name = "snail_species")
public class Species implements NameMapper.Mappable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer speciesId;
	
	@ManyToOne
	@JoinColumn(name = "genus_id")
	private Genus genus;
	
	@OneToMany(mappedBy = "species")
	private List<Subspecies> subspecies;
	
	@Column(nullable = false)
	private String name;

	@JsonProperty("id")
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

	@JsonIgnore
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

}
