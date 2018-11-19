package com.kasokuz.snaildb.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.kasokuz.snaildb.utils.IdNameInterface;

@Entity
@Table(name = "snail_superfamily")
public class Superfamily implements IdNameInterface {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer superfamilyId;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "superfamily")
	private List<Family> families;
	
	@Column(nullable = false)
	private String name;
	
	@ManyToMany
	@JoinTable(name = "snail_superfamily_taxonomer", joinColumns = @JoinColumn(name = "superfamily_id"), inverseJoinColumns = @JoinColumn(name = "taxonomer_id"))
	private List<Taxonomer> taxonomers = new ArrayList<>();
	
	@Column(nullable = false)
	private Integer taxonomyYear;
	
	@Column(nullable = false)
	private Boolean complete = false;
	
	@Column(nullable = false)
	private String type;
	
	@Column(nullable = false)
	private Boolean airBreathing;
	
	public Superfamily() {}
	
	public Superfamily(String name, List<Taxonomer> taxonomers, Integer taxonomyYear, Boolean complete, String type, Boolean airBreathing) {
		this.name = name;
		this.taxonomers = taxonomers;
		this.taxonomyYear = taxonomyYear;
		this.complete = complete;
		this.type = type;
		this.airBreathing = airBreathing;
	}

	@Override
	public Integer getId() {
		return superfamilyId;
	}

	public Integer getSuperfamilyId() {
		return superfamilyId;
	}

	public void setSuperfamilyId(Integer superfamilyId) {
		this.superfamilyId = superfamilyId;
	}

	public List<Family> getFamilies() {
		return families;
	}

	public void setFamilies(List<Family> families) {
		this.families = families;
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

	public Boolean getComplete() {
		return complete;
	}

	public void setComplete(Boolean complete) {
		this.complete = complete;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getAirBreathing() {
		return airBreathing;
	}

	public void setAirBreathing(Boolean airBreathing) {
		this.airBreathing = airBreathing;
	}

}
