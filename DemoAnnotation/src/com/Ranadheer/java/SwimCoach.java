package com.Ranadheer.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class SwimCoach implements Coach{
    @Value("${foo.email}")
    private String email;
    private FortuneService fortuneService;
    public SwimCoach(FortuneService fortuneService){
        this.fortuneService= fortuneService;
    }

    public String getEmail(){
        return email;
    }
    @Override
    public String getDailyWorkout() {
        return "Swim for 30 mins";
    }

    @Override
    public String getFortune() {
        return this.fortuneService.getFortune();
    }
}
