package com.oauth2.models.dto;

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
public class RolesDTO {
	
	private String name;
	private List<PermissionsDTO> permissions;
	
	public RolesDTO(Role role) {
		this.name = role.getName();
		this.permissions = new ArrayList<>();
		this.permissions.addAll(role.getPermissions().stream()
				.map(PermissionsDTO::new)
				.collect(Collectors.toList()));
	}
	

}
