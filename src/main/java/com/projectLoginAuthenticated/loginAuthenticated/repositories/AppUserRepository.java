package com.projectLoginAuthenticated.loginAuthenticated.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectLoginAuthenticated.loginAuthenticated.model.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

	
	public AppUser findByEmail(String email);
}
