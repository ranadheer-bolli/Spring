package com.ranadheer.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.ranadheer.dao.*.*(..))")
    public void forDaoPackage(){}

    @Pointcut("execution(* com.ranadheer.service.*.*(..))")
    public void forServicePackage(){}

    @Pointcut("execution(* com.ranadheer.entity.*.*(..))")
    public void forEntityPackage(){}

    @Pointcut("forDaoPackage() || forServicePackage() || forEntityPackage()")
    public void  forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
        String method = joinPoint.getSignature().toShortString();
        myLogger.info("=======> In Before: Calling Method"+method);

        Object[] args = joinPoint.getArgs();

        for(Object arg: args){
            myLogger.info("===========> argument"+arg);
        }
    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result"
    )
    public void display(JoinPoint joinPoint,Object result){
        String method = joinPoint.getSignature().toShortString();
        myLogger.info("=======> In AfterReturning: Calling Method"+method);
        myLogger.info("Result"+result);
    }




}
