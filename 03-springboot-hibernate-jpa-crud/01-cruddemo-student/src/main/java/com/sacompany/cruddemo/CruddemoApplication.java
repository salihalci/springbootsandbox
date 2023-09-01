package com.sacompany.cruddemo;

import com.sacompany.cruddemo.dao.StudentDAO;
import com.sacompany.cruddemo.entitiy.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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

            // retrieveAllStudents(studentDAO);

            // retrieveStudentByLastName(studentDAO);
            // updateStudent(studentDAO);

            //updateAll(studentDAO);
            //deleteStudent(studentDAO);
            deleteStudentByLastName(studentDAO);
        };

    }

    private void updateAll(StudentDAO studentDAO) {

        // update all records

        int row = studentDAO.updateAllStudents("updatedemail@test.com");
        System.out.println("Updated row count :"+row);
    }

    private void updateStudent(StudentDAO studentDAO) {
        //find object based on id
        System.out.println("Find student by id executed");
        Student tempStudent = studentDAO.findById(1);
        System.out.println("Object is:" + tempStudent);
        //set new field ex change name

        tempStudent.setEmail("test@yahoo.com");
        System.out.println("Updated object is :" + tempStudent);
        //update object

        studentDAO.updateStudent(tempStudent);
        System.out.println("Update completed.");
    }

    private void retrieveStudentByLastName(StudentDAO studentDAO) {

        List<Student> lastNamedList = studentDAO.findByLastName("Alcı");

        for (Student student : lastNamedList) {
            System.out.println(student);

        }
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

        System.out.println("Retrieved Student details are:" + retStudent.toString());


    }


    private void retrieveAllStudents(StudentDAO studentDAO) {
        System.out.println("Retrieve all students started....");

        //Get students
        List<Student> studentList = studentDAO.findAll();


        //Show students
        for (Student tempStudent : studentList) {
            System.out.println(tempStudent);

        }
        // System.out.println(studentDAO.findAll().toString());
        System.out.println("Retrieve all students ended....");


    }

    private void deleteStudent(StudentDAO studentDAO){

        studentDAO.deleteStudent(1);

    }


    private void deleteStudentByLastName(StudentDAO studentDAO){

       int result= studentDAO.deleteStudentByLasName("Şen");

        System.out.println("Deleted row count is:"+result);
    }
}
