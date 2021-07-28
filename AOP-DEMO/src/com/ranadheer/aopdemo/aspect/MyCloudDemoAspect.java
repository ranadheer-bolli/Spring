package com.ranadheer.aopdemo.aspect;

import com.ranadheer.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class MyCloudDemoAspect {
    @Before("com.ranadheer.aopdemo.aspect.AopExpressions.forDAOPackageNotGetterSetter()")
    public void beforeAddAccount(JoinPoint joinPoint){
        System.out.println("---------------MY CLOUD DEMO ASPECT-----------------");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("METHOD SIGNATURE "+methodSignature);

        // display args

        // get args
        Object[] args = joinPoint.getArgs();

        // iterate thru loop

        for(Object arg : args){

            if(arg instanceof Account){
                System.out.println(((Account) arg).getName());
            }
            else System.out.println(arg);
        }
        System.out.println();

    }
}
