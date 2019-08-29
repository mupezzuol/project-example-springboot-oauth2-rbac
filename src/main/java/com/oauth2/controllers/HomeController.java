package com.oauth2.controllers;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/")
@Api(tags="Home - Test", description="Test Request")
@RestController
@Slf4j
public class HomeController {
	
	@GetMapping()
	@ResponseBody
	public String home() {
		return "Hello World - Welcome API REST";
	}
	
	
	@ApiOperation(value = "Test List String")
	@GetMapping("/list")
	public ResponseEntity<HashMap<String, String>> testList() {
		
		//Test using '@Slf4j' for Lombok
		log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");
        
		HashMap<String, String> values = new HashMap<>();
		values.put("Campo1", "Valor1");
		values.put("Campo2", "Valor2");
		values.put("Campo3", "Valor3");
		return ResponseEntity.ok(values);
	}

	
	@PreAuthorize("hasPermission(returnObject, {'user_create', 'user_update', 'abcd_create', 'abcd_read', 'user_read'})")
	@DeleteMapping("/user")
	public ResponseEntity<String> update(){
		System.out.print("I'm in the method!");
		return ResponseEntity.ok(new String("OK -> Permission OK"));
	}
	
	
}
