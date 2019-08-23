package com.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ProjectExampleSpringbootOauth2RbacApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectExampleSpringbootOauth2RbacApplication.class, args);
	}

}
