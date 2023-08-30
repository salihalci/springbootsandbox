package com.sacomp.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BaseballCoach implements Coach{

    public BaseballCoach() {
        System.out.println("Contstucter executed during bean initalization!");
    }

    @Override
    public String getDailyWorkout() {
        return "Baseball Coach!!";
    }
}
