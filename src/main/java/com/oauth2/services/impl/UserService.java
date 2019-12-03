package com.oauth2.services.impl;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oauth2.entities.User;
import com.oauth2.repositories.IUserRepository;
import com.oauth2.services.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository userRepository;

	@Override
	public Optional<User> findUserByUuid(UUID uuid) {
		try {
			Optional<User> user = userRepository.findByUuid(uuid);
			
			if (user.isPresent()) {
				return user;
			}
			
			return Optional.empty();
		} catch (NoSuchElementException exception) {
			return Optional.empty();
		}
	}

}
