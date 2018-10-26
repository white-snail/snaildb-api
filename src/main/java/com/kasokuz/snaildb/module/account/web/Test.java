package com.kasokuz.snaildb.module.account.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kasokuz.snaildb.module.account.dto.User;
import com.kasokuz.snaildb.module.account.service.AccountService;

@RestController
public class Test {

	@Autowired
	private AccountService service;
	
	@GetMapping(value = "user/{username}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User getUser(@PathVariable String username) {
		return service.getUser(username);
	}
	
}