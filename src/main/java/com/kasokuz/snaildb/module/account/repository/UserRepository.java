package com.kasokuz.snaildb.module.account.repository;

import org.springframework.data.repository.CrudRepository;

import com.kasokuz.snaildb.module.account.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByUsernameIgnoreCase(String username);
	
}
