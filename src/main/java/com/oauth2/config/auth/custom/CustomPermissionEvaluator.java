package com.oauth2.config.auth.custom;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.google.common.base.Splitter;
import com.oauth2.entities.Permission;
import com.oauth2.entities.Role;
import com.oauth2.entities.User;
import com.oauth2.services.IUserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomPermissionEvaluator implements PermissionEvaluator {

	@Autowired
	private IUserService userService;
	
	@Override
	public boolean hasPermission(Authentication auth, Object targetDomainObject, Object authorities) {
		
		if ((auth == null) || (authorities == null)){
            return false;
        }
		
		try {
			List<String> authoritiesValid = validAuthorities(auth, authorities);

			//Valid
			if(!authoritiesValid.isEmpty()) {
				log.trace("Authorities Valid for this method");
				return true;
			}else {
				log.trace("Authorities Invalid for this method");
				return false;
			}
		} catch (Exception e) {
			log.error("Error in method hasPermission in class CustomPermissionEvaluator: ", e);
			return false;
		}
	}

	
	private List<String> validAuthorities(Authentication auth, Object authorities) {
		log.debug("Begin - validating user permission in method validPermissions in class CustomPermissionEvaluator");
		
		UUID uuidUser = UUID.fromString(auth.getPrincipal().toString());
		
		List<String> authoritiesMethod = Splitter.on(',')
				.trimResults()
				.omitEmptyStrings()
				.splitToList(authorities.toString().substring(1, authorities.toString().length()-1));
		
		List<String> authoritiesValid = new ArrayList<>();
		
		if (authoritiesMethod.get(0).equals("roles")) {
			authoritiesValid = validWithRoles(uuidUser, authoritiesMethod);
		} 
		
		if (authoritiesMethod.get(0).equals("permissions")) {
			authoritiesValid = validWithPermissions(uuidUser, authoritiesMethod);
		}
		
		log.debug("End - validating user permission in method validPermissions in class CustomPermissionEvaluator");
		return authoritiesValid;
	}

	
	private List<String> validWithRoles(UUID uuidUser, List<String> rolesMethod) {
		List<String> rolesUser = new ArrayList<>();
		List<String> rolesValid;
		
		User user = userService.findByUuid(uuidUser)
				.orElseThrow(() -> new UsernameNotFoundException("Error -> hasPermission for UUID: " + uuidUser));
		
		for (Role r : user.getRoles()) {
			rolesUser.add(r.getName());
		}
		
		rolesValid = rolesMethod.stream()
				.filter(rolesUser::contains)
				.collect(Collectors.toList());
		return rolesValid;
	}
	
	
	private List<String> validWithPermissions(UUID uuidUser, List<String> permissionsMethod) {
		List<String> permissionsUser = new ArrayList<>();
		List<String> permissionsValid;
		
		User user = userService.findByUuid(uuidUser)
				.orElseThrow(() -> new UsernameNotFoundException("Error -> hasPermission for UUID: " + uuidUser));
		
		
		for (Role r : user.getRoles()) {
			for (Permission p : r.getPermissions()) {
				permissionsUser.add(p.getName());
			}
		}
		
		permissionsValid = permissionsMethod.stream()
				.filter(permissionsUser::contains)
				.collect(Collectors.toList());
		return permissionsValid;
	}
	
	
	@Override
	public boolean hasPermission(Authentication auth, Serializable targetId, String targetType, Object permission) {
		return true;
	}
	
}

/*
Exemplos:
OR -> @PreAuthorize("hasPermission(returnObject, {'user_create', 'user_update', 'abcd_create', 'abcd_read', 'user_read'})")
AND -> @PreAuthorize("hasPermission(returnObject, {'user_read'}) AND hasPermission(returnObject, {'user_update'})")
@PreAuthorize("hasPermission(#id, 'Foo', 'read')")
 */
