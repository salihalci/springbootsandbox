package com.sacomp.springcoredemo.config;

import com.sacomp.springcoredemo.common.Coach;
import com.sacomp.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    //beanID default to the method name beanID will be swimCoach. @salci
    @Bean("aqua")//set customBeanID
    public Coach swimCoach1(){

        return new SwimCoach();
    }



}
