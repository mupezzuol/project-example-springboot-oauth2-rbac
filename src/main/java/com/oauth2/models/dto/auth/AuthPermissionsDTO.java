package com.oauth2.models.dto.auth;

import com.oauth2.entities.Permission;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthPermissionsDTO {

	private String name;
	
	public AuthPermissionsDTO(Permission permission) {
		this.name = permission.getName();
	}
	
}
