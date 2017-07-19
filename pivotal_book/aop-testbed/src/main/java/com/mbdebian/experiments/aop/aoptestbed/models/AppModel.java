package com.mbdebian.experiments.aop.aoptestbed.models;

import org.springframework.stereotype.Component;

/**
 * @author Manuel Bernal Llinares
 * Project: aop-testbed
 * Package: com.mbdebian.experiments.aop.aoptestbed.models
 * Timestamp: 2017-07-19 10:21
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 */
@Component
public class AppModel {
    public String sayHello() {
        return "Hello World!";
    }
}
