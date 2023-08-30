package com.sacomp.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class BaseballCoach implements Coach {

    public BaseballCoach() {

        System.out.println("BaseballCoach created!"+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Baseball Coach!!";
    }
}
