package com.kasokuz.snaildb.module.snail.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kasokuz.snaildb.module.snail.utils.NameMapper;

@Entity
@Table(name = "snail_superfamily")
public class Superfamily implements NameMapper.Mappable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer superfamilyId;
	
	@OneToMany(mappedBy = "superfamily")
	private List<Family> families;
	
	@Column(nullable = false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "taxonomer_id")
	private Taxonomer taxonomer;
	
	@Column(nullable = false)
	private Integer taxonomyYear;

	@JsonProperty("id")
	public Integer getSuperfamilyId() {
		return superfamilyId;
	}

	public void setSuperfamilyId(Integer superfamilyId) {
		this.superfamilyId = superfamilyId;
	}

	@JsonIgnore
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

}
