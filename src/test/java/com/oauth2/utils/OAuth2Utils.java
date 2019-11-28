package com.oauth2.utils;

import org.apache.commons.codec.binary.Base64;
import org.springframework.security.oauth2.common.util.JacksonJsonParser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class OAuth2Utils {
	
	/*
	 * HttpBasic with Username and Password (client credentials) for Authorization in Header with OAuth2
	 */
	public static final String userAndPass = "ProjectExampleOAuth2Security:secretProjectExampleOAuth2Security";
	
	//Login
	public static String getOAuth2Login(String username, String password, MockMvc mockMvc) throws Exception {
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "password");
		params.add("username", username);
		params.add("password", password);
		
		String clientCredentials = new String(Base64.encodeBase64(userAndPass.getBytes()));
		
		ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post("/oauth/token").params(params)
				.header("Authorization", "Basic " + clientCredentials)
				.accept("application/json;charset=UTF-8"))
				.andExpect(MockMvcResultMatchers.status().isOk());
		
		return response.andReturn().getResponse().getContentAsString();
	}
	
	public static String getAccessToken(String response) throws Exception {
		return new JacksonJsonParser().parseMap(response).get("access_token").toString();
	}
	
	public static String getTokenType(String response) throws Exception {
		return new JacksonJsonParser().parseMap(response).get("token_type").toString();
	}
	
	public static String getTokenUserUuid(String response) throws Exception {
		return new JacksonJsonParser().parseMap(response).get("user_uuid").toString();
	}

	public static String getTokenUserCompany(String response) throws Exception {
		return new JacksonJsonParser().parseMap(response).get("user_company").toString();
	}

}