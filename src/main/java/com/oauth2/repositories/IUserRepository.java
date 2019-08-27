package com.oauth2.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oauth2.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

	public Optional<User> findByName(String name);
	
	public Optional<User> findByEmail(String email);
	
	public Optional<User> findByUuid(String uuid);
	
}
