package com.oauth2.config.errors;

import static org.springframework.http.HttpStatus.FORBIDDEN;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	private final HttpMessageConverter<String> messageConverter;

	private final ObjectMapper mapper;

	public CustomAccessDeniedHandler() {
		this.mapper = new ObjectMapper();
		this.messageConverter = new StringHttpMessageConverter();
	}

	@Override
	public void handle(HttpServletRequest httpServletRequest, 
			HttpServletResponse httpServletResponse,
			AccessDeniedException ex) throws IOException {

		ServerHttpResponse outputMessage = new ServletServerHttpResponse(httpServletResponse);
		
		try {
			ApiError apiError = new ApiError(FORBIDDEN, ex.getMessage(),
					"Unauthorized access, please contact your system administrator.");
			
			outputMessage.setStatusCode(HttpStatus.FORBIDDEN);
			
			messageConverter.write(mapper.writeValueAsString(apiError), MediaType.APPLICATION_JSON, outputMessage);
			
		} catch (Exception e) {
			log.error("Error method handle in class CustomAccessDeniedHandler: ", e);
		}  finally {
			outputMessage.close();
		}
		
	}

}