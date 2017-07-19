package com.mbdebian.experiments.aop.aoptestbed.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Manuel Bernal Llinares
 * Project: aop-testbed
 * Package: com.mbdebian.experiments.aop.aoptestbed.aspects
 * Timestamp: 2017-07-19 10:23
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 */
@Aspect
@Component
public class MethodCallLogger {
    private static final Logger logger = LoggerFactory.getLogger(MethodCallLogger.class);

    @Before("execution(* com.mbdebian.experiments.aop.aoptestbed..* (..))")
    public void beforeCallingModelMethods(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Before calling method '{}'", methodName);
    }
}
