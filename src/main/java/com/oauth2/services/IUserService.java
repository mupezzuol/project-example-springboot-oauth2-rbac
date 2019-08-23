package com.oauth2.services;

import java.util.List;

import com.oauth2.entities.User;

public interface IUserService {
	
	public List<User> findAll();
	
	public User save(User user);

	public User findByName(String name);
	
	public User findByEmail(String email);
	
}
