package com.Ranadheer.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    private FortuneService fortuneService;
    @Autowired
    public TennisCoach( @Qualifier("happyFortuneService") FortuneService fortuneService){
        this.fortuneService=fortuneService;
    }

    public  String getFortune(){
        return this.fortuneService.getFortune();
    }
    @Override
    public String getDailyWorkout() {
        return "20 pushups everyday";
    }
}
