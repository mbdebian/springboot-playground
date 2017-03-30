package com.google.mbdebian.springboot.playground.microservices.tutorial;

import com.netflix.zuul.ZuulFilter;

/**
 * Project: spring-microservices-zuul
 * Package: com.google.mbdebian.springboot.playground.microservices.tutorial
 * Timestamp: 2017-03-30 23:33
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 */
public class MyZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        // This is where you execute the logic of your filter
        System.out.println("This request has passed through the custom Zuul Filter...");
        return null;
    }
}
