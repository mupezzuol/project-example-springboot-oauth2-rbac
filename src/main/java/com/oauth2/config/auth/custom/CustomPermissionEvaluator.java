package com.oauth2.config.auth.custom;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.oauth2.entities.User;
import com.oauth2.services.impl.UserService;

public class CustomPermissionEvaluator implements PermissionEvaluator {
	
	@Autowired
	private UserService userService;
	
	//@PreAuthorize("hasPermission(returnObject, {'user_read', 'user_update'})")
	@Override
    public boolean hasPermission(Authentication auth, Object targetDomainObject, Object permission) {
		Object uuid_user = auth.getPrincipal();
		
//		User user = userService
//				.findByUuid(uuid_user.toString())
//				.orElseThrow(() -> new UsernameNotFoundException("Error -> hasPermission for UUID: "+uuid_user));
		
		
		return true;
	
    }
	
	
	//@PreAuthorize("hasPermission(#id, 'Foo', 'read')")
    @Override
    public boolean hasPermission(Authentication auth, Serializable targetId, String targetType, Object permission) {
    	return true;
    }
    
    
}
