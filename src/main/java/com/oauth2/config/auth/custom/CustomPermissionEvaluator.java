package com.oauth2.config.auth.custom;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.oauth2.entities.User;
import com.oauth2.services.impl.UserService;

public class CustomPermissionEvaluator implements PermissionEvaluator {

	@Autowired
	private UserService userService;

	// @PreAuthorize("hasPermission(returnObject, {'user_read', 'user_update'})")
	@Override
	public boolean hasPermission(Authentication auth, Object targetDomainObject, Object permission) {
		try {
			UUID uuid_user = UUID.fromString(auth.getPrincipal().toString());
			
			User user = userService.findByUuid(uuid_user)
					.orElseThrow(() -> new UsernameNotFoundException("Error -> hasPermission for UUID: " + uuid_user));

			
			// 1. Resgatar permissões do usuário
			// 2. Comparar permissões do usuário x 'permission' que poderá acessar

			return true;
		} catch (Exception e) {
			System.out.println("Error Method hasPermission in class CustomPermissionEvaluator: "+e.getMessage());
			return false;
		}
	}

	
	// @PreAuthorize("hasPermission(#id, 'Foo', 'read')")
	@Override
	public boolean hasPermission(Authentication auth, Serializable targetId, String targetType, Object permission) {
		return true;
	}
	

}
