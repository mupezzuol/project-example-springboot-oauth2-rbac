package com.oauth2.config.auth.custom;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.google.common.base.Splitter;
import com.oauth2.entities.Permission;
import com.oauth2.entities.User;
import com.oauth2.repositories.IPermissionRepository;
import com.oauth2.services.impl.UserService;

public class CustomPermissionEvaluator implements PermissionEvaluator {

	@Autowired
	private UserService userService;
	
	@Autowired
	private IPermissionRepository permissionRepository;

	
	//OR -> @PreAuthorize("hasPermission(returnObject, {'user_create', 'user_update', 'abcd_create', 'abcd_read', 'user_read'})")
	//AND -> @PreAuthorize("hasPermission(returnObject, {'user_read'}) AND hasPermission(returnObject, {'user_update'})")
	@Override
	public boolean hasPermission(Authentication auth, Object targetDomainObject, Object permission) {
		
		if ((auth == null) || (permission == null)){
            return false;
        }
		
		try {
			UUID uuid_user = UUID.fromString(auth.getPrincipal().toString());
			List<String> permissionsMethod = Splitter.on(',')
					.trimResults()
					.omitEmptyStrings()
					.splitToList(permission.toString().substring(1, permission.toString().length()-1));
			
			User user = userService.findByUuid(uuid_user)
					.orElseThrow(() -> new UsernameNotFoundException("Error -> hasPermission for UUID: " + uuid_user));
			
			List<Permission> permissions = this.permissionRepository.findByRoles(user.getRoles());
			List<String> permissionsUser = permissions.stream()
					.map(p -> p.getName())
					.collect(Collectors.toList());
			
			List<String> permissionsValid = permissionsMethod.stream()
			              .filter(p -> permissionsUser.contains(p))
			              .collect(Collectors.toList());

			//Valid
			if(!permissionsValid.isEmpty()) {
				return true;
			}else {
				return false;
			}
			
		} catch (Exception e) {
			System.out.println("Error Method hasPermission in class CustomPermissionEvaluator: "+e.getMessage());
			return false;
		}
	}

	
	//@PreAuthorize("hasPermission(#id, 'Foo', 'read')")
	@Override
	public boolean hasPermission(Authentication auth, Serializable targetId, String targetType, Object permission) {
		return true;
	}
	

}
