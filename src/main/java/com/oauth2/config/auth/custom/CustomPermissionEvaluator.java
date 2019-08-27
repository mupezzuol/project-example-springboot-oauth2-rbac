package com.oauth2.config.auth.custom;

import java.io.Serializable;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

public class CustomPermissionEvaluator implements PermissionEvaluator {
   
	//@PreAuthorize("hasPermission(returnObject, {'user_read', 'user_update'})")
	@Override
    public boolean hasPermission(Authentication auth, Object targetDomainObject, Object permission) {
		
		return true;
	
    }
	
	
	//@PreAuthorize("hasPermission(#id, 'Foo', 'read')")
    @Override
    public boolean hasPermission(Authentication auth, Serializable targetId, String targetType, Object permission) {
    	return true;
    }
    
    
}
