package com.oauth2.seeders;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.oauth2.repositories.IUserRepository;

@Component
public class UsersSeeder {

	private final IUserRepository userRepository;

	@Autowired
    public UsersSeeder(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

	@EventListener
	public void seed(ContextRefreshedEvent event) throws IOException {
		// TODO
		seedUserTable();
	}

	private void seedUserTable() {
		long count = this.userRepository.count();
		if (count == 0) {
			// TODO
		}

	}

}
