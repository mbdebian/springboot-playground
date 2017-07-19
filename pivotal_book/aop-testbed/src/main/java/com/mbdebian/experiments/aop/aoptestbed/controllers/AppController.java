package com.mbdebian.experiments.aop.aoptestbed.controllers;

import com.mbdebian.experiments.aop.aoptestbed.models.AppModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Manuel Bernal Llinares
 * Project: aop-testbed
 * Package: com.mbdebian.experiments.aop.aoptestbed.controllers
 * Timestamp: 2017-07-19 10:22
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 */
@RestController
public class AppController {
    @Autowired
    private AppModel appModel;

    @RequestMapping("/hello")
    public String hello() {
        return appModel.sayHello();
    }
}
