package com.teamb.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
@EnableFeignClients
public class OrdersMsLatestApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdersMsLatestApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfig() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/orders/process-order/*")
						.or(PathSelectors.ant("/orders/get-all-books-ordered/*"))
						.or(PathSelectors.ant("/orders/get-order-details/*"))
						.or(PathSelectors.ant("/orders/get-all-orders/*"))
						.or(PathSelectors.ant("/orders/return-book/*/*/*")))
				.apis(RequestHandlerSelectors.basePackage("com.teamb.orders"))
				.build()
				.apiInfo(null);
	}

}
