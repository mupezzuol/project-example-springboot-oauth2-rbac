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
			Optional<User> user = userRepository.findByName(userName);

			if (user.isPresent()) {
				return user.get();
			}

			return null;
		} catch (NoSuchElementException exception) {
			return null;
		}
	}

	public User findByLogin(String login) {
		try {
			Optional<User> user = userRepository.findByLogin(login);

			if (user.isPresent()) {
				return user.get();
			}
			
			return null;
		} catch (NoSuchElementException exception) {
			return null;
		}
	}

	@Override
	public Optional<User> findByUuid(UUID uuid) {
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
