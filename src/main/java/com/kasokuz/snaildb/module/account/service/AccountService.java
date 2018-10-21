package com.kasokuz.snaildb.module.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kasokuz.snaildb.module.account.dto.User;
import com.kasokuz.snaildb.module.account.repository.RoleRepository;
import com.kasokuz.snaildb.module.account.repository.UserRepository;

@Service
public class AccountService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	public User getUser(String username) {
		return userRepository.findByUsernameIgnoreCase(username);
	}
	
}
