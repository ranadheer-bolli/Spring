package com.ranadheer.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
    @Pointcut("execution(* com.ranadheer.aopdemo.dao.*.*(..))")
    public void forDAOPackage(){}

    @Pointcut("execution(* com.ranadheer.aopdemo.dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* com.ranadheer.aopdemo.dao.*.set*(..))")
    public void setter(){}
    @Pointcut("forDAOPackage() && !(getter() || setter())")
    public void forDAOPackageNotGetterSetter(){}

}
