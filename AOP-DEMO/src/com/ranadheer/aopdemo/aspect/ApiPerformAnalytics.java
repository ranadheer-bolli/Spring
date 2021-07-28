package com.ranadheer.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class ApiPerformAnalytics {
    @Before("com.ranadheer.aopdemo.aspect.AopExpressions.forDAOPackageNotGetterSetter()")
    public void beforeAddAccount(){
        System.out.println("---------------API PERFORM ANALYTICS ASPECT-----------------");
    }
}
