package com.aditya.SpringBootMVC;

//Aspect : a class which will manage these concerns
//Join point : a point of execution where you'll call a particular advice
//Advice : a log method
//Weaving : the time when you want to connect methods with advice

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect //made it a aspect
@Component //making spring know that a class like this exists
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    //runs before the method is executed
    @Before("execution(public * com.aditya.SpringBootMVC.AlienController.getAliens())")
    public void logBefore(){
        LOGGER.info("getAliens method called from log");
    }

    //runs after the method is executed without any issue
    @AfterReturning("execution(public * com.aditya.SpringBootMVC.AlienController.getAliens())")
    public void logAfterReturn(){
        LOGGER.info("Retrieved data succesfully");
    }

    //runs after the method causes any exception
    @AfterThrowing("execution(public * com.aditya.SpringBootMVC.AlienController.getAliens())")
    public void logAfterThrowing(){
        LOGGER.info("There was an issue");
    }

}
