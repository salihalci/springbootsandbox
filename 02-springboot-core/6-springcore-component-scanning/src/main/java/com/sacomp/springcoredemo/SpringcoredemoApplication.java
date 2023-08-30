package com.sacomp.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//We define explicitly  package name to scan @salci.
//base package i de vermek gerek @salci
@SpringBootApplication(scanBasePackages = {"com.sacomp.util",
		"com.sacomp.springcoredemo"})
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
