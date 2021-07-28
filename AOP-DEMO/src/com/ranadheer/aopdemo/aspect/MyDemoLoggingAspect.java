package com.ranadheer.aopdemo.aspect;

import com.ranadheer.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("com.ranadheer.aopdemo.aspect.AopExpressions.forDAOPackageNotGetterSetter()")
    public void beforeAddAccount(){
        System.out.println("---------------MY DEMO LOGGING ASPECT-----------------");
    }
    @After("execution(* com.ranadheer.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinally(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("Mehtod    :   " + method);
        System.out.println("---------------AFTER FINALLY MY DEMO LOGGING ASPECT-----------------");
    }

    @AfterReturning(
            pointcut = "execution(* com.ranadheer.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterAdvice(JoinPoint joinPoint, List<Account> result){
        String method = joinPoint.getSignature().toShortString();
        System.out.println("Mehtod    :   "+method);
        System.out.println("---------------AFTER RETURNING MY DEMO LOGGING ASPECT-----------------");
        if(!result.isEmpty()){
            result.get(0);

        }
        convertUpperCase(result);
    }

    public void convertUpperCase(List<Account> result){
        for(Account account:result){
            String name= account.getName().toUpperCase();
            account.setName(name);
        }
    }


    @AfterThrowing(
            pointcut = "execution(* com.ranadheer.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "error")
    public void afterAdvice(JoinPoint joinPoint, Throwable error){
        String method = joinPoint.getSignature().toShortString();
        System.out.println("Mehtod    :   "+method);
        System.out.println("---------------AFTER THROWING MY DEMO LOGGING ASPECT-----------------");
        System.out.println(error);
    }


}
