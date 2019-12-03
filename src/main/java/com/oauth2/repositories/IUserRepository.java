package com.oauth2.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oauth2.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

	public Optional<User> findByLogin(String login);
	
	public Optional<User> findByUuid(UUID uuid);
	
}
