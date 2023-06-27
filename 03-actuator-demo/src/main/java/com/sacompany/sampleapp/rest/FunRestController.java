package com.sacompany.sampleapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/hello")
    public String helloWorld(){
        return "HelloWorld!";
    }
}
