package com.kasokuz.snaildb.module.account.dto;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleId;
	
	@Column(nullable = false)
	private String role;

}
