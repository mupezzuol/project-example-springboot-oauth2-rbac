package com.oauth2.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.oauth2.entities.User;
import com.oauth2.repositories.IUserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthenticationService implements UserDetailsService{

	@Autowired
	IUserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) {
		
		try {
			User user = userRepository
					.findByEmail(email)
					.orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " not founded"));
			return new UserPrincipal(user);
			
		} catch (UsernameNotFoundException e) {
			log.error("Error Username not found method loadUserByUsername in class AuthenticationService: ", e);
		} catch (Exception e) {
			log.error("Error method loadUserByUsername in class AuthenticationService: ", e);
		}
		
		return null;
	}

}
