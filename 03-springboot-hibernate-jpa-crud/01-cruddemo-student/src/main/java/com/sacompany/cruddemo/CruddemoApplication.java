package com.sacompany.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	//Created for commandline application @salci
	//Executed after spring beans loaded.
	@Bean
	public CommandLineRunner commandLineRunner(String[] args){

		return runner->{
			System.out.println("Hello World");
		};

	}
}
