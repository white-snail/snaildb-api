package com.kasokuz.snaildb.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.kasokuz.snaildb.utils.IdNameInterface;

@Entity
@Table(name = "snail_subfamily")
public class Subfamily implements IdNameInterface {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer subfamilyId;
	
	@Column(nullable = false)
	private String name;
	
	@ManyToMany
	@JoinTable(name = "snail_subfamily_taxonomer", joinColumns = @JoinColumn(name = "subfamily_id"), inverseJoinColumns = @JoinColumn(name = "taxonomer_id"))
	private List<Taxonomer> taxonomers = new ArrayList<>();
	
	@Column(nullable = false)
	private Integer taxonomyYear;
	
	public Subfamily() {}
	
	public Subfamily(String name, List<Taxonomer> taxonomers, Integer taxonomyYear) {
		this.name = name;
		this.taxonomers = taxonomers;
		this.taxonomyYear = taxonomyYear;
	}

	@Override
	public Integer getId() {
		return subfamilyId;
	}

	public Integer getSubfamilyId() {
		return subfamilyId;
	}

	public void setSubfamilyId(Integer subfamilyId) {
		this.subfamilyId = subfamilyId;
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
