package com.google.mbdebian.springboot.playground.microservices.cdn;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SpringBootApplication
@RestController
public class RedirectorSimpleServiceApplication {

	@Value("${server.port}")
	private String serverPort;

	@Value("${shouldRedirect}")
	private boolean shouldRedirect;

	@Value("${redirectUrl}")
	private String redirectUrl;

	@RequestMapping("/getData")
	public String getData(HttpServletResponse response) throws IOException {
		if (shouldRedirect) {
			response.sendRedirect(redirectUrl + "/getData");
			return "";
		} else {
			return "Your data has been served from service on port " + serverPort;
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(RedirectorSimpleServiceApplication.class, args);
	}
}
