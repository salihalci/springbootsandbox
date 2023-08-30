package com.sacomp.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


//component annotation marks the class as Spring bean
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)

//@Lazy
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("CricketCoach created!" + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Cricket Coach!!";
    }


}
