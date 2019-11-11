package com.oauth2.config.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	public static final String[] DOCS_INFRA_API = {
            "/swagger-resources/**", 
            "//swagger-resources/configuration/**", 
            "/swagger-ui.html", 
            "/swagger-ui.html/**",
            "/v2/api-docs", 
            "/webjars/**", 
            "/actuator/**",
            "/**.html",
            "/configuration/**"};

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
    	return super.authenticationManagerBean();
    }
    
    @Override
 	public void configure(WebSecurity web) {
 		web.ignoring()
 			.antMatchers(HttpMethod.GET, "/")//Test
 			.antMatchers(DOCS_INFRA_API);
 	}

}