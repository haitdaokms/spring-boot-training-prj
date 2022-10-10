package com.kms.training.trainingproject.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectConfig {
    private Logger logger = LoggerFactory.getLogger(AspectConfig.class);
    @Before("execution(* com.kms.training.trainingproject.service.BookServiceImpl.*(..))")
    public void before(JoinPoint joinPoint){
        logger.info(" Before the execution " + joinPoint.toString());
    }

//    After: do function and do not care about the status of function is error or success
    @After("execution(* com.kms.training.trainingproject.service.BookServiceImpl.*(..))")
    public void after(JoinPoint joinPoint) {
        logger.info(" After the execution " + joinPoint.toString());
    }
//    AfterThrowing: do function when something goes error
    @AfterThrowing("execution(* com.kms.training.trainingproject.service.BookServiceImpl.*(..))")
    public void afterThrowing(JoinPoint joinPoint) {
        logger.info(" Error during execution " + joinPoint.toString());
    }
//    AfterReturning: only be executed when function's status is successful
    @AfterReturning("execution(* com.kms.training.trainingproject.service.BookServiceImpl.*(..))")
    public void afterReturning(JoinPoint joinPoint) {
        logger.info(" After did a successful execution " + joinPoint.toString());
    }
}
