package com.oauth2.models.dto;

import com.oauth2.entities.Permission;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PermissionsDTO {

	private String name;
	
	public PermissionsDTO(Permission permission) {
		this.name = permission.getName();
	}
	
}
