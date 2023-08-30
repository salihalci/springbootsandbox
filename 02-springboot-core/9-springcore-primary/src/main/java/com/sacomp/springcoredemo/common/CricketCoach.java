package com.sacomp.springcoredemo.common;

import org.springframework.stereotype.Component;


//component annotation marks the class as Spring bean
@Component
public class CricketCoach implements Coach{
    public CricketCoach() {
        System.out.println("Contstucter executed during bean initalization!");
    }

    @Override
    public String getDailyWorkout() {
        return "Cricket Coach!!";
    }
}
