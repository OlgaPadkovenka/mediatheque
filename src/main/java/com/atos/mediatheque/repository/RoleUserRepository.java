package com.atos.mediatheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atos.mediatheque.entity.RoleUser;

public interface RoleUserRepository extends JpaRepository<RoleUser, Long>{

	RoleUser findByRoleName(String roleName);
}
