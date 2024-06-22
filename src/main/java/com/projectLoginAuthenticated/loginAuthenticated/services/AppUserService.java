package com.projectLoginAuthenticated.loginAuthenticated.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projectLoginAuthenticated.loginAuthenticated.model.AppUser;
import com.projectLoginAuthenticated.loginAuthenticated.repositories.AppUserRepository;

@Service
public class AppUserService implements UserDetailsService {

	private final AppUserRepository repo;
	
	
	public AppUserService(AppUserRepository repo) {
		super();
		this.repo = repo;
	}



	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		AppUser appUser = repo.findByEmail(email);
		
		if(appUser != null) {
			var springUser = User.withUsername(appUser.getEmail())
					.password(appUser.getPassword())
					.roles(appUser.getRole())
					.build();
			
			return springUser;
		}
		return null;
	}

}