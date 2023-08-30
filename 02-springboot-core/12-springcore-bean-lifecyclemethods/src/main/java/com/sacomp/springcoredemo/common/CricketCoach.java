package com.sacomp.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


//component annotation marks the class as Spring bean
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)

//@Lazy
public class CricketCoach implements Coach{
    public CricketCoach() {
        System.out.println("CricketCoach created!"+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Cricket Coach!!";
    }



    //Constructer method. Executed after bean creation.
    @PostConstruct
    public void doMyStartupStaff(){
        System.out.println("Startup staff executed for CricketCoach component!");

    }

    //Destructer method. Executed before bean destroyed.
    @PreDestroy
    public void doMyEnduupStaff(){
        System.out.println("Endup staff executed for CricketCoach component!");
    }
}
