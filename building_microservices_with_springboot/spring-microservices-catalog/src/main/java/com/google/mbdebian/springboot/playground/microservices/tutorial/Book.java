package com.google.mbdebian.springboot.playground.microservices.tutorial;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Project: spring-microservices-catalog
 * Package: com.google.mbdebian.springboot.playground.microservices.tutorial
 * Timestamp: 2017-03-17 22:54
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 */
@Entity
public class Book {

    @Id
    private long bookId;

    private String title;

    private int pageCount;

    private String authorFirstName;

    private String authorLastName;

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

}

