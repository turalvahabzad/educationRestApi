package com.example.education3.student.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

@Aspect
@Component
public class RestControllerInputLogger {

    private static final Logger logger = LoggerFactory.getLogger(RestControllerInputLogger.class);

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void controller() {}

    @Before("controller() && @annotation(requestMapping)")
    public void logRequest(JoinPoint joinPoint, RequestMapping requestMapping) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest request = requestAttributes.getRequest();
            logger.info("Incoming request: {} {} with parameters: {}",
                    request.getMethod(),
                    request.getRequestURI(),
                    Arrays.toString(joinPoint.getArgs()));
        }
    }

    @AfterReturning(pointcut = "controller()", returning = "response")
    public void logResponse(JoinPoint joinPoint, Object response) {
        logger.info("Returning response: {}", response);
    }
}
