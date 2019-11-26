package com.oauth2.security;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OAuth2Test {
	
	@Autowired
    private MockMvc mockMvc;
	
	@Test
	public void loginTest() throws Exception {
		String responseLogin = OAuth2UtilsTest.getOAuth2Login("test", "1234", mockMvc);
		String accessToken = OAuth2UtilsTest.getAccessToken(responseLogin);
				
		MvcResult result = mockMvc
				.perform(get("/auth/test/login")
						.header("Authorization", "Bearer " + accessToken)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		assertThat(result.getResponse().getStatus()).isEqualTo(200);//200 - OK
	}
	
	@Test
	public void authoritiesTest() throws Exception {
		String responseLogin = OAuth2UtilsTest.getOAuth2Login("test", "1234", mockMvc);
		String accessToken = OAuth2UtilsTest.getAccessToken(responseLogin);
		String user_uuid = OAuth2UtilsTest.getTokenUserUuid(responseLogin);
		
		MvcResult result = mockMvc
				.perform(get("/auth/authorities/" + user_uuid)
						.header("Authorization", "Bearer " + accessToken)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		assertThat(result.getResponse().getStatus()).isEqualTo(200);//200 - OK
	}
	
	@Test
	public void permissionTest() throws Exception {
		String responseLogin = OAuth2UtilsTest.getOAuth2Login("test", "1234", mockMvc);
		String accessToken = OAuth2UtilsTest.getAccessToken(responseLogin);
		
		MvcResult result = mockMvc
				.perform(delete("/auth/test/permission")
						.header("Authorization", "Bearer " + accessToken)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		assertThat(result.getResponse().getStatus()).isEqualTo(200);//200 - OK
	}

}
