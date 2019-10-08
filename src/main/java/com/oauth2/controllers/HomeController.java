package com.oauth2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RequestMapping("/")
@Api(tags="Home - Test", description="Unrestricted request testing")
@RestController
public class HomeController {
	
	@GetMapping()
	@ResponseBody
	public String home() {
		return "Hello World - Welcome API REST";
	}
	
}
