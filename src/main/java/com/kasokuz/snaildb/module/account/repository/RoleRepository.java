package com.kasokuz.snaildb.module.account.repository;

import org.springframework.data.repository.CrudRepository;

import com.kasokuz.snaildb.module.account.dto.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

}
