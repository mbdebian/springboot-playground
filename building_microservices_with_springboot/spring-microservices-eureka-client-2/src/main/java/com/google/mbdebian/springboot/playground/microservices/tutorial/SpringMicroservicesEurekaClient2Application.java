package com.google.mbdebian.springboot.playground.microservices.tutorial;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class SpringMicroservicesEurekaClient2Application {

	@Autowired
	private EurekaClient client;

	@RequestMapping("/serverinfo")
	public String serviceInfo() {
		InstanceInfo instance = client.getNextServerFromEureka("MyClient", false);
		return instance.getHomePageUrl();
	}

	@RequestMapping("/servicedescription")
	public String serviceDescription() {
		return "This is a description message from Client 2, registered on Eureka";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservicesEurekaClient2Application.class, args);
	}
}
