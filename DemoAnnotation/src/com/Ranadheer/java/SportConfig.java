package com.Ranadheer.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// Same as XML compomemt Scanning
@Configuration
@PropertySource("classpath:sport.properties")
//@ComponentScan("com.Ranadheer.java")
public class SportConfig {

    // define bean for sad fortune
    @Bean
    public FortuneService sadFortuneService(){
        return new SadFortuneService();
    }
    // define bean for swimcoach and inject dependendcies
    @Bean
    public Coach swimCoach(){
        return new SwimCoach(sadFortuneService());
    }


}
