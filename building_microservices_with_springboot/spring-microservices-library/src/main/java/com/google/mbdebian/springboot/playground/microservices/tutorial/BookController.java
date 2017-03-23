package com.google.mbdebian.springboot.playground.microservices.tutorial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Project: spring-microservices-library
 * Package: com.google.mbdebian.springboot.playground.microservices.tutorial
 * Timestamp: 2017-03-21 11:12
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 */

@RestController
@RequestMapping("/book/search")
public class BookController {
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @RequestMapping("/title")
    public String findByTitle(@Param("title") String title) throws URISyntaxException {
        RestTemplate template = new RestTemplate();
        URI uri = new URI("http://localhost:9999/book/search/title?title=" + title);
        logger.info("Contacting microservice at '" + uri.toString() + "'");
        return template.getForObject(uri, String.class);
    }
}
