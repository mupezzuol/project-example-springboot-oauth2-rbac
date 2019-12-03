package com.oauth2.services;

import java.util.Optional;
import java.util.UUID;

import com.oauth2.entities.User;

public interface IUserService {
	
	public Optional<User> findUserByUuid(UUID uuid);
	
}
