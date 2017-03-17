package com.google.mbdebian.springboot.playground.microservices.tutorial;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * Project: spring-microservices-application
 * Package: com.google.mbdebian.springboot.playground.microservices.tutorial
 * Timestamp: 2017-03-17 10:53
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 */
@Configuration
public class DemoConfiguration {
    @Bean
    public List<String> cats() {
        return Arrays.asList("Bengal", "Lion");
    }
}
