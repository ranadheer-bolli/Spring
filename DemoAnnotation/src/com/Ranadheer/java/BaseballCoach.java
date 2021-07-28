package com.Ranadheer.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class BaseballCoach implements Coach {

    private FortuneService fortuneService;
    public BaseballCoach(){
        System.out.println("Inside Baseball default constructor");
    }
    @Autowired
    @Qualifier("randomFortuneService")
    public void setFortuneService(FortuneService fortuneService){
        System.out.println("Inside Setter method");
        this.fortuneService=fortuneService;
    }

    @Override
    public String getDailyWorkout(){
        return  "Practice batting for 30 mins";
    }

    @Override
    public String getFortune() {
        return this.fortuneService.getFortune();
    }

}
