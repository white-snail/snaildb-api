package com.kasokuz.snaildb.repository;

import org.springframework.data.repository.CrudRepository;

import com.kasokuz.snaildb.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByUsernameIgnoreCase(String username);
	
}
