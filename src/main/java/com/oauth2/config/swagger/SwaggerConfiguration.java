package com.oauth2.config.swagger;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.oauth2.entities.User;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {

	@Bean
	public Docket forumApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.oauth2.controllers"))
				.paths(PathSelectors.any())
				.build()
				.ignoredParameterTypes(disableTemplateClassesModels())
				
				// Setting global parameter
				.globalOperationParameters(Arrays.asList(
						new ParameterBuilder()
						.name("Authorization")
						.description("Header for token JWT")
						.modelRef(new ModelRef("string"))//Type parameter
						.parameterType("header")
						.required(false)
						.build()))
						.apiInfo(apiInfo());
	}
	
	
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
        	.title("Project Example OAuth2 RBAC - API")
            .description("This is a project base with OAuth2.")
            .contact(new Contact("Project Base", "www.project.com", "project@hotmail.com"))
            .license("License vetweb-api 1.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
            .version("1.0.0")
            .build();
    }
	
	
	//Method that returns templates that will be hidden in the API documentation
	private Class[] disableTemplateClassesModels(){
		ArrayList<Class> modelsForDisable = new ArrayList<Class>();
		
		//Entities
		//modelsForDisable.add(Role.class);
		modelsForDisable.add(User.class);
		
		//Models DTO
		//modelsForDisable.add(TokenDTO.class);//Token
		//modelsForDisable.add(ClinicCreateDTO.class);
		//modelsForDisable.add(UserCreateDTO.class);
		
		//Models Form
		//modelsForDisable.add(LoginForm.class);//LoginForm
		//modelsForDisable.add(ClinicCreateForm.class);
		//modelsForDisable.add(UserCreateForm.class);
		
		return modelsForDisable.toArray(new Class[modelsForDisable.size()]);
	}
	
	
}
