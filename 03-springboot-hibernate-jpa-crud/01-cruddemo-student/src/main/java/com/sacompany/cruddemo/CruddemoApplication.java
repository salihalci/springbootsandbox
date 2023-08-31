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
           // createStudent(studentDAO);

           // retrieveStudent(studentDAO);

            retrieveAllStudents(studentDAO);
        };

    }

    private void createStudent(StudentDAO studentDAO) {

        //create student
        System.out.println("Creating student object...");
        Student theStudent = new Student("Sema", "Alcı", "alcisem@gmail.com");

        //save student
        System.out.println("Saving the student...");
        studentDAO.save(theStudent);
        //show studentid

        System.out.println("Saved student. Generated id: " + theStudent.getId());

    }

    private void retrieveStudent(StudentDAO studentDAO) {

        //create student
        System.out.println("Creating student object...");
        Student theStudent = new Student("Salih", "Alcı", "salihalci@gmail.com");

        //save student
        System.out.println("Saving the student...");
        studentDAO.save(theStudent);
        //show studentid
        System.out.println("Saved student. Generated id: " + theStudent.getId());


        //REtrieve persisted student object
        System.out.println("Rerieve student object...");

        Student retStudent = studentDAO.findById(theStudent.getId());

        System.out.println("Retrieved Student details are:" +retStudent.toString());


    }


    private void retrieveAllStudents(StudentDAO studentDAO){
        System.out.println("Retrieve all students started....");
        System.out.println(studentDAO.findAll().toString());
        System.out.println("Retrieve all students ended....");


    }
}
