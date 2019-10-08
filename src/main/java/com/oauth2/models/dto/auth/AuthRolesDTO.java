package com.oauth2.models.dto.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.oauth2.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthRolesDTO {
	
	private String name;
	private List<AuthPermissionsDTO> permissions;
	
	public AuthRolesDTO(Role role) {
		this.name = role.getName();
		this.permissions = new ArrayList<>();
		this.permissions.addAll(role.getPermissions().stream()
				.map(AuthPermissionsDTO::new)
				.collect(Collectors.toList()));
	}
	

}
