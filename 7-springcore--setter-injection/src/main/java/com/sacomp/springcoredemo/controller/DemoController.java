package com.sacomp.springcoredemo.controller;

import com.sacomp.springcoredemo.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    /*
        //tells spring to inject dependency
        //if we have one constructer autowire keyword is optional.

        @Autowired
        public DemoController(Coach theCoach) {
            this.myCoach = theCoach;
        }
    */


    //setter injection example @salci
    //method name can be different
   /*
    @Autowired
    public void setCoach(Coach theCoach){

        this.myCoach=theCoach;
    }
*/


    @Autowired
    public void coachInitalizer(Coach theCoach){

        this.myCoach=theCoach;
    }
    @GetMapping("/dailyworkout")
    public String dailyWorkout(){


        return myCoach.getDailyWorkout();


    }
}
