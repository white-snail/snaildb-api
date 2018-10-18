package com.kasokuz.snaildb.module.snail.entity;

import javax.persistence.*;

@Entity
@Table(name = "snail_family")
public class Family {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer familyId;
	
	@ManyToOne
	@JoinColumn(name = "superfamily_id")
	private Superfamily superfamily;
	
	@Column(nullable = false)
	private String name;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
