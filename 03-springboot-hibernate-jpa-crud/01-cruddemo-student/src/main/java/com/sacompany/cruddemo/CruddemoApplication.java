package com.sacompany.cruddemo;

import com.sacompany.cruddemo.dao.StudentDAO;
import com.sacompany.cruddemo.entitiy.Student;
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
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        return runner -> {
            createStudent(studentDAO);
        };

    }

    private void createStudent(StudentDAO studentDAO) {

        //create student
        System.out.println("Creating student object...");
        Student theStudent=new Student("Sema","Alcı","alcisem@gmail.com");

        //save student
        System.out.println("Saving the student...");
        studentDAO.save(theStudent);
        //show studentid

        System.out.println("Saved student. Generated id: "+theStudent.getId());

    }
}
