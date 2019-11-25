package com.oauth2.models.dto.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.oauth2.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthUserAndRolesAndAuthoritiesDTO {
	
	private String uuid;
	private String name;
	private String login;
	private String email;
	private List<AuthRolesDTO> roles;
	
	public AuthUserAndRolesAndAuthoritiesDTO(User user) {
			this.uuid = user.getUuid().toString();
			this.name = user.getName();
			this.login = user.getLogin();
			this.email = user.getContact().getEmail();
			this.roles = new ArrayList<>();
			this.roles.addAll(user.getRoles().stream()
					.map(AuthRolesDTO::new)
					.collect(Collectors.toList()));
		}

}
