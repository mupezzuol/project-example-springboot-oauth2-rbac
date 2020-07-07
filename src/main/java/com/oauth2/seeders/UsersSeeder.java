package com.oauth2.seeders;

import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.oauth2.entities.Company;
import com.oauth2.entities.Permission;
import com.oauth2.entities.Role;
import com.oauth2.entities.User;
import com.oauth2.entities.embedded.Contact;
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
		seedUserCompanyRolePermission();
	}

	private void seedUserCompanyRolePermission() {
		long count = this.userRepository.count();
		if (count == 0) {
			Role role1 = new Role("ADMIN");
			Role role2 = new Role("AUX");
			Role role3 = new Role("TESTE");
			
			Permission permission1 = new Permission("user_create");
			Permission permission2 = new Permission("user_read");
			Permission permission3 = new Permission("user_update");
			Permission permission4 = new Permission("user_delete");
			Permission permission5 = new Permission("abcd");
			Permission permission6 = new Permission("efgh");
			
			role1.setPermissions(Arrays.asList(permission1,permission2,permission3,permission4));
			role2.setPermissions(Arrays.asList(permission2,permission3));
			role3.setPermissions(Arrays.asList(permission5,permission6));
			
			Company company1 = new Company();
			company1.setCnpj("12.345.678/0001-99");
			company1.setCorporateName("Gambiarra Company LTDA");
			company1.setRegisterStatus(Boolean.TRUE);
			
			Company company2 = new Company();
			company2.setCnpj("22.333.444/0001-55");
			company2.setCorporateName("Company Test LTDA");
			company2.setRegisterStatus(Boolean.TRUE);
			
			User user1 = new User();
			user1.setUuid(UUID.randomUUID());
			user1.setName("Murillo Pezzuol");
			user1.setLogin("mupezzuol");
			user1.setContact(new Contact("murillopezzuol@hotmail.com", "", ""));
			user1.setPassword(new BCryptPasswordEncoder().encode("mupezzuol"));
			user1.setRegisterStatus(Boolean.TRUE);
			user1.setCompany(company1);
			user1.setRoles(Arrays.asList(role1));
			
			User user2 = new User();
			user2.setUuid(UUID.randomUUID());
			user2.setName("Administrator");
			user2.setLogin("admin");
			user2.setContact(new Contact("admin@hotmail.com", "", ""));
			user2.setPassword(new BCryptPasswordEncoder().encode("admin"));
			user2.setRegisterStatus(Boolean.TRUE);
			user2.setCompany(company1);
			user2.setRoles(Arrays.asList(role1));
			
			User user3 = new User();
			user3.setUuid(UUID.randomUUID());
			user3.setName("Test");
			user3.setLogin("test");
			user3.setContact(new Contact("test@hotmail.com", "", ""));
			user3.setPassword(new BCryptPasswordEncoder().encode("1234"));
			user3.setRegisterStatus(Boolean.TRUE);
			user3.setCompany(company2);
			user3.setRoles(Arrays.asList(role2, role3));
			
			this.userRepository.saveAll(Arrays.asList(user1, user2, user3));
		}

	}

}
