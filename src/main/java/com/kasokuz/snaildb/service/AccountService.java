package com.kasokuz.snaildb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kasokuz.snaildb.domain.User;
import com.kasokuz.snaildb.repository.UserRepository;

@Service
public class AccountService {

	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public User getUser(String username) {
		return userRepository.findByUsernameIgnoreCase(username);
	}
	
}
