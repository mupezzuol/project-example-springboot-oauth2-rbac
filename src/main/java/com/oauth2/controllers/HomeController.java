package com.oauth2.controllers;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="Welcome - Get Started - Home", description="Test Request")
@RestController
public class HomeController {

	
	@GetMapping("/")
	@ResponseBody
	public String home() {
		return "Hello World - Welcome API REST";
	}
	
	
	@ApiOperation(value = "Test List String")
	@GetMapping("/list")
	public ResponseEntity<HashMap<String, String>> testList() {
		HashMap<String, String> values = new HashMap<>();
		values.put("Campo1", "Valor1");
		values.put("Campo2", "Valor2");
		values.put("Campo3", "Valor3");
		return ResponseEntity.ok(values);
	}
	
	
}
