package com.google.mbdebian.springboot.playground.microservices.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringMicroservicesConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservicesConfigApplication.class, args);
	}
}
