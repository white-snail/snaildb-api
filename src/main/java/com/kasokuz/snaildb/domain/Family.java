package com.kasokuz.snaildb.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.kasokuz.snaildb.utils.IdNameInterface;

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
	
	@ManyToMany
	@JoinTable(name = "snail_family_taxonomer", joinColumns = @JoinColumn(name = "family_id"), inverseJoinColumns = @JoinColumn(name = "taxonomer_id"))
	private List<Taxonomer> taxonomers =  new ArrayList<>();
	
	@Column(nullable = false)
	private Integer taxonomyYear;
	
	public Family() {}
	
	public Family(Superfamily superfamily, String name, List<Taxonomer> taxonomers, Integer taxonomyYear) {
		this.superfamily = superfamily;
		this.name = name;
		this.taxonomers = taxonomers;
		this.taxonomyYear = taxonomyYear;
	}

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
