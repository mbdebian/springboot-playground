package com.google.mbdebian.springboot.playground.microservices.tutorial;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
@EnableCircuitBreaker
public class SpringMicroservicesHystrixApplication {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/startClient")
	@HystrixCommand(fallbackMethod = "failover")
	public List<String> startClient() {
		return this.restTemplate.getForObject("http://localhost:8888/service", List.class);
	}

	public List<String> failover() {
		return Arrays.asList("Default1", "Default2");
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservicesHystrixApplication.class, args);
	}
}
