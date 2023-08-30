package com.sacomp.springcoredemo.rest;

import com.sacomp.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;
    private Coach anotherCoach;


    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach,
                          @Qualifier("cricketCoach") Coach theAnoterCoach) {

        System.out.println("Demo Controller created!"+getClass().getSimpleName());

        this.myCoach = theCoach;
        this.anotherCoach=theAnoterCoach;
    }

    @GetMapping("/dailyworkout")
    public String dailyWorkout() {

        return myCoach.getDailyWorkout();

    }


    @GetMapping("/check")
    public String check(){

        return "Comparing beans :"+(myCoach==anotherCoach);//if singleton returns true
    }
}
