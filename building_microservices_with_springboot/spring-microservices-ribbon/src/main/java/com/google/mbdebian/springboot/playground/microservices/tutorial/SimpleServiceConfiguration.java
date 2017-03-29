package com.google.mbdebian.springboot.playground.microservices.tutorial;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * Project: spring-microservices-ribbon
 * Package: com.google.mbdebian.springboot.playground.microservices.tutorial
 * Timestamp: 2017-03-29 19:58
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 */
public class SimpleServiceConfiguration {
    @Autowired
    public IClientConfig ribbonClientConfig;

    // This bean defines how you're going to ping the services
    @Bean
    public IPing ping(IClientConfig config) {
        return new PingUrl();
    }

    // This IRule defines the load balancing strategy that you're going to use
    @Bean
    public IRule rule(IClientConfig config) {
        return new AvailabilityFilteringRule();
    }

}
