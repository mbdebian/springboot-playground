package com.google.mbdebian.springboot.playground.microservices.tutorial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMicroservicesCatalogApplication {
	private static final Logger logger = LoggerFactory.getLogger(SpringMicroservicesCatalogApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservicesCatalogApplication.class, args);
	}
}
