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
public class AuthUserRoleAndAuthoritiesDTO {
	
	private String uuid;
	private List<AuthRolesDTO> roles;
	
	public AuthUserRoleAndAuthoritiesDTO(User user) {
			this.uuid = user.getUuid().toString();
			this.roles = new ArrayList<>();
			this.roles.addAll(user.getRoles().stream()
					.map(AuthRolesDTO::new)
					.collect(Collectors.toList()));
		}

}
