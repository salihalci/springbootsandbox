package com.sa.springboot.myFirstApp.myfirstapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${programmer.name}")
    private String programmerName;
    @GetMapping("/")
    public String sayHello(){
        return "Hello  :" +programmerName;

    }

    @GetMapping("/warm")
    public String warm(){

        return "Warm";
    }
}
