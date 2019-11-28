package com.oauth2.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RequestMapping("/")
@Api(tags = "Home", description = "Serviço de teste da API")
@RestController
public class HomeController {

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> home() {
		return ResponseEntity.ok("API Online");
	}

}
