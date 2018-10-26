package com.kasokuz.snaildb.module.snail.dto;

import java.util.List;

import javax.persistence.*;

import com.kasokuz.snaildb.module.snail.utils.IdNameInterface;

@Entity
@Table(name = "snail_family")
public class Family implements IdNameInterface {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer familyId;
	
	@ManyToOne
	@JoinColumn(name = "superfamily_id")
	private Superfamily superfamily;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "family")
	private List<Genus> genuses;
	
	@Column(nullable = false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "taxonomer_id")
	private Taxonomer taxonomer;
	
	@Column(nullable = false)
	private Integer taxonomyYear;
	
	@Override
	public Integer getId() {
		return familyId;
	}

	public Integer getFamilyId() {
		return familyId;
	}

	public void setFamilyId(Integer familyId) {
		this.familyId = familyId;
	}

	public Superfamily getSuperfamily() {
		return superfamily;
	}

	public void setSuperfamily(Superfamily superfamily) {
		this.superfamily = superfamily;
	}

	public List<Genus> getGenuses() {
		return genuses;
	}

	public void setGenuses(List<Genus> genuses) {
		this.genuses = genuses;
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