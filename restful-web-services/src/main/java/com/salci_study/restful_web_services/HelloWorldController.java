package com.salci_study.restful_web_services;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean("Hello World " + name);
    }

    //GET i18N
    @GetMapping("/hello-world-i18n")
    public String helloWorldi18N() {
        Locale locale = LocaleContextHolder.getLocale();
        System.out.println(locale.getLanguage());
        System.out.println("Salih Alcı");

        return messageSource.getMessage("good.morning.message",null,"Default Message",locale);


    }
}
