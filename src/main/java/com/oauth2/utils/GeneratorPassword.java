package com.oauth2.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeneratorPassword {
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("Tds_prod@integracao2020"));
	}
}
