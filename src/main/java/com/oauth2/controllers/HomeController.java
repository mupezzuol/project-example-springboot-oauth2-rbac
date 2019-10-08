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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oauth2.entities.User;
import com.oauth2.models.dto.auth.AuthUserRoleAndAuthoritiesDTO;
import com.oauth2.services.IUserService;

import io.swagger.annotations.Api;

@RequestMapping("/")
@Api(tags="Home - Test", description="Test Request")
@RestController
public class HomeController {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping()
	@ResponseBody
	public String home() {
		return "Hello World - Welcome API REST";
	}
	
	@GetMapping(value = "authorities/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AuthUserRoleAndAuthoritiesDTO> getAuthorities(@PathVariable String uuid){
		
		try {
			UUID uuid_user = UUID.fromString(uuid.toString());
			
			User user = userService.findByUuid(uuid_user)
					.orElseThrow(() -> new UsernameNotFoundException("Error -> hasPermission for UUID: " + uuid_user));
			
			AuthUserRoleAndAuthoritiesDTO dto = new AuthUserRoleAndAuthoritiesDTO(user);
			
			return ResponseEntity.ok(dto);
		} catch (Exception e) {
			return null;
		}
		
		
	}
	

	@PreAuthorize("hasPermission(returnObject, {'user_create', 'user_update', 'abcd_create', 'abcd_read', 'user_read'})")
	@DeleteMapping("/user")
	public ResponseEntity<String> update(){
		System.out.print("I'm in the method!");
		return ResponseEntity.ok(new String("OK -> Permission OK"));
	}
	
	
}
