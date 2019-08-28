package com.oauth2.services.impl;

import java.util.List;
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
	public List<User> findAll() {
		return this.userRepository.findAll();
	}

	@Override
	public User save(User user) {
		this.userRepository.save(user);
		return user;
	}

	
	public User findByName(String userName) {
		try {
			return userRepository.findByName(userName).get();
		} catch (NoSuchElementException exception) {
			return null;
		}
	}
	
	public User findByEmail(String email) {
		try {
			return userRepository.findByEmail(email).get();
		} catch (NoSuchElementException exception) {
			return null;
		}
	}

	@Override
	public Optional<User> findByUuid(UUID uuid) {
		try {
			return userRepository.findByUuid(uuid);
		} catch (NoSuchElementException exception) {
			return null;
		}
	}
	

}
