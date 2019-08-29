package com.oauth2.repositories;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.oauth2.entities.Permission;
import com.oauth2.entities.Role;
import com.oauth2.entities.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private IUserRepository userRepository;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	
	@Test
	public void createShouldPersistData() {
		String password = new BCryptPasswordEncoder().encode("1234");
		Set<Role> roles = createRolesAndPermissionsMock();
		LocalDate dtInclussion = LocalDate.now();
		
		User user = createUserMock(password, roles, dtInclussion);
				
		this.userRepository.save(user);
		
		//Tests
		Assertions.assertThat(user.getUserId()).isNotNull();
		Assertions.assertThat(user.getUuid()).isNotNull();
		Assertions.assertThat(user.getName()).isEqualTo("Gildo");
		Assertions.assertThat(user.getEmail()).isEqualTo("gildo@gmail.com");
		Assertions.assertThat(user.getPassword()).isEqualTo(password);
		Assertions.assertThat(user.getRoles()).isEqualTo(roles);
		Assertions.assertThat(user.getInclusionDate()).isEqualTo(dtInclussion);
	}
	
	
	
	
	
	
	
	
	
	
	// CREATE MOCK -> USER + ROLES + PERMISSIONS
	private User createUserMock(String password, Set<Role> roles, LocalDate dtInclussion) {
		UUID uuid = UUID.randomUUID();
		return new User(uuid, "Gildo", "gildo@gmail.com", password, roles, dtInclussion);
	}
	
	private Set<Role> createRolesAndPermissionsMock() {
		Set<Permission> permissions1 = new HashSet<>();
		Set<Permission> permissions2 = new HashSet<>();
		Permission p1 = new Permission("user_create");
		Permission p2 = new Permission("user_read");
		Permission p3 = new Permission("user_update");
		Permission p4 = new Permission("user_delete");
		permissions1.add(p1);
		permissions1.add(p2);
		permissions1.add(p3);
		permissions1.add(p4);
		
		permissions2.add(p2);
		permissions2.add(p3);
		
		Set<Role> roles = new HashSet<>();
		Role r1 = new Role("admin");
		Role r2 = new Role("aux");
		
		r1.setPermissions(permissions1);
		r2.setPermissions(permissions2);
		
		roles.add(r1);
		roles.add(r2);
		
		return roles;
	}
	
	
}
