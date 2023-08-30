package com.sacomp.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class TennisCoach implements Coach {


    public TennisCoach() {
        System.out.println("Tennis Coach created!"+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Tennis Coach!!!";
    }
}
