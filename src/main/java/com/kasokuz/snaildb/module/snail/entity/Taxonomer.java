package com.kasokuz.snaildb.module.snail.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "snail_taxonomer")
public class Taxonomer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer taxonomerId;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String surname;

	@JsonProperty("id")
	public Integer getTaxonomerId() {
		return taxonomerId;
	}

	public void setTaxonomerId(Integer taxonomerId) {
		this.taxonomerId = taxonomerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
}
