package com.oauth2.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oauth2.entities.User;
import com.oauth2.models.dto.auth.AuthUserAndRolesAndAuthoritiesDTO;
import com.oauth2.services.IUserService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/auth")
@Api(tags="Authorities", description="This is about Authentication")
@RestController
@Slf4j
public class AuthController {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping(value = "/authorities/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AuthUserAndRolesAndAuthoritiesDTO> getAuthorities(@PathVariable String uuid){
		try {
			UUID uuid_user = UUID.fromString(uuid.toString());
			
			User user = userService.findByUuid(uuid_user)
					.orElseThrow(() -> new UsernameNotFoundException("Error -> hasPermission for UUID: " + uuid_user));
			
			return ResponseEntity.ok(new AuthUserAndRolesAndAuthoritiesDTO(user));
		} catch (IllegalArgumentException ie) {
			log.error("Error method getAuthorities in class AuthController: "+ie.getMessage());
			return ResponseEntity.badRequest().build();//400
		} 
		catch (Exception ex) {
			log.error("Error method getAuthorities in class AuthController: "+ex.getMessage());
			return ResponseEntity.badRequest().build();//400
		}
	}
	
	@PreAuthorize("hasPermission(returnObject, {'user_create', 'user_update', 'abcd_create', 'abcd_read', 'user_read'})")
	@DeleteMapping("/test")
	public ResponseEntity<String> testAuthorities(){
		System.out.print("I'm in the method!");
		return ResponseEntity.ok(new String("OK -> Permission OK"));
	}
	
}
