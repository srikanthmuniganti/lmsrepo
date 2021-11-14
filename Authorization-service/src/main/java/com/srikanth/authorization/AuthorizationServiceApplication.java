package com.srikanth.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EnableFeignClients
@SpringBootApplication
public class AuthorizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorizationServiceApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfig() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/authentication/add-user")
						.or(PathSelectors.ant("/authentication/auth"))
						.or(PathSelectors.ant("/authentication/validate"))
						.or(PathSelectors.ant("/authentication/getName"))
						.or(PathSelectors.ant("/authentication/edit-user"))
						.or(PathSelectors.ant("/authentication/reset-pwd"))
						.or(PathSelectors.ant("/authentication/get-user/*")))
				.apis(RequestHandlerSelectors.basePackage("com.srikanth.authorization"))
				.build()
				.apiInfo(null);
	}

}
