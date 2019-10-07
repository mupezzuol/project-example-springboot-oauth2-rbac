package com.oauth2.config.errors;

import static org.springframework.http.HttpStatus.FORBIDDEN;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	private final HttpMessageConverter<String> messageConverter;

    private final ObjectMapper mapper;

    public CustomAccessDeniedHandler() {
        this.mapper = new ObjectMapper();
		this.messageConverter = new StringHttpMessageConverter();
    }
    
    @Override
    public void handle(
    		HttpServletRequest httpServletRequest, 
    		HttpServletResponse httpServletResponse, 
    		AccessDeniedException ex) throws JsonProcessingException, IOException {
    	
    	ApiError apiError = new ApiError(FORBIDDEN, ex.getMessage(), ex);

        ServerHttpResponse outputMessage = new ServletServerHttpResponse(httpServletResponse);
        outputMessage.setStatusCode(HttpStatus.FORBIDDEN);

        messageConverter.write(mapper.writeValueAsString(apiError), MediaType.APPLICATION_JSON, outputMessage);
    }
    
}