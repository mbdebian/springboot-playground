package com.google.mbdebian.springboot.playground.microservices.tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Project: spring-microservices-eureka-client
 * Package: com.google.mbdebian.springboot.playground.microservices.tutorial
 * Timestamp: 2017-03-29 11:42
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 */
@RestController
public class ExampleController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/execute")
    public String execute() {
        return this.restTemplate.getForObject("http://MYOTHERCLIENT/servicedescription", String.class);
    }
}
