package com.kasokuz.snaildb.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.kasokuz.snaildb.utils.IdNameInterface;

@Entity
@Table(name = "snail_subgenus")
public class Subgenus implements IdNameInterface {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer subgenusId;
	
	@Column(nullable = false)
	private String name;
	
	@ManyToMany
	@JoinTable(name = "snail_subgenus_taxonomer", joinColumns = @JoinColumn(name = "subgenus_id"), inverseJoinColumns = @JoinColumn(name = "taxonomer_id"))
	private List<Taxonomer> taxonomers = new ArrayList<>();
	
	@Column(nullable = false)
	private Integer taxonomyYear;
	
	public Subgenus() {}

	public Subgenus(String name, List<Taxonomer> taxonomers, Integer taxonomyYear) {
		this.name = name;
		this.taxonomers = taxonomers;
		this.taxonomyYear = taxonomyYear;
	}
	
	@Override
	public Integer getId() {
		return subgenusId;
	}

	public Integer getSubgenusId() {
		return subgenusId;
	}

	public void setSubgenusId(Integer subgenusId) {
		this.subgenusId = subgenusId;
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
