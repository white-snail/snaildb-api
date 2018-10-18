package com.kasokuz.snaildb.module.snail.entity;

import javax.persistence.*;

@Entity
@Table(name = "snail_genus")
public class Genus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer genusId;
	
	@ManyToOne
	@JoinColumn(name = "family_id")
	private Family family;
	
	@Column(nullable = false)
	private String name;

	public Integer getGenusId() {
		return genusId;
	}

	public void setGenusId(Integer genusId) {
		this.genusId = genusId;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
