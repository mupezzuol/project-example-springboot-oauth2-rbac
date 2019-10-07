package com.oauth2.models.dto;

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
public class UserRoleAndAuthoritiesDTO {
	
	private String uuid;
	private List<RolesDTO> roles;
	
	public UserRoleAndAuthoritiesDTO(User user) {
			this.uuid = user.getUuid().toString();
			this.roles = new ArrayList<>();
			this.roles.addAll(user.getRoles().stream()
					.map(RolesDTO::new)
					.collect(Collectors.toList()));
		}

}
