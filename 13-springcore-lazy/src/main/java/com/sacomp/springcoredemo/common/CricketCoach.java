package com.sacomp.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


//component annotation marks the class as Spring bean
@Component
//@Lazy
public class CricketCoach implements Coach{
    public CricketCoach() {
        System.out.println("CricketCoach created!"+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Cricket Coach!!";
    }
}
