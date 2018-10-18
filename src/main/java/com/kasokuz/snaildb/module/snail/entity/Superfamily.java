package com.kasokuz.snaildb.module.snail.entity;

import javax.persistence.*;

@Entity
@Table(name = "snail_superfamily")
public class Superfamily {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer superfamilyId;
	
	@Column(nullable = false)
	private String name;

	public Integer getSuperfamilyId() {
		return superfamilyId;
	}

	public void setSuperfamilyId(Integer superfamilyId) {
		this.superfamilyId = superfamilyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
