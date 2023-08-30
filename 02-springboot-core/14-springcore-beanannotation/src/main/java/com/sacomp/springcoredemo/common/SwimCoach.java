package com.sacomp.springcoredemo.common;

public class SwimCoach implements Coach{

    public SwimCoach() {
        System.out.println("Swimcoach constructer executed!");
    }

    @Override
    public String getDailyWorkout() {
        return "Swim everyday 1000mt !";
    }
}
