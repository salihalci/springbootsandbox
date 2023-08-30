package com.sacomp.util;

import org.springframework.stereotype.Component;


//component annotation marks the class as Spring bean
@Component
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice every day 30 minutes.!!!";
    }
}
