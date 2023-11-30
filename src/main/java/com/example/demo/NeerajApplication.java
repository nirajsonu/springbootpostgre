package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
@EntityScan("com.example.demo.models")
public class NeerajApplication {
	public static void main(String[] args) {
		SpringApplication.run(NeerajApplication.class, args);
		System.out.println("Neeraj");
	}
	
	@Bean
	public OpenAPI openAPI() {
		Info info=new Info().description("Developed by Neeraj").title("Review Analysis project").version("v1");
		return new OpenAPI().info(info);
	}
}
