package com.google.mbdebian.springboot.playground.microservices.tutorial;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Project: spring-microservices-catalog
 * Package: com.google.mbdebian.springboot.playground.microservices.tutorial
 * Timestamp: 2017-03-17 22:55
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 */
@RepositoryRestResource(path="book", collectionResourceRel="book")
public interface BookRepository extends JpaRepository<Book, Long> {

    @RestResource(rel="title", path="title")
    public List<Book> findByTitle(@Param("title") String title);

}
