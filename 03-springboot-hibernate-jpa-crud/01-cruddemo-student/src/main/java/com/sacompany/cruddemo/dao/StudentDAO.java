package com.sacompany.cruddemo.dao;

import com.sacompany.cruddemo.entitiy.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);
    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);


    void updateStudent(Student theStudent);
    int updateAllStudents(String email);

    void deleteStudent(Integer id);
    int deleteStudentByLasName(String lastName);


}
