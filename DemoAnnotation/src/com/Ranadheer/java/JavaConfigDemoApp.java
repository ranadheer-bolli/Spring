package com.Ranadheer.java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.Annotation;

public class JavaConfigDemoApp {
    public static void main(String[] args) {
        // read the spring config file
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);

        // get the bean from Spring Container
        Coach coach = context.getBean("baseballCoach",Coach.class);

        // call the method on bean
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getFortune());

        //close context
        context.close();
    }
}
