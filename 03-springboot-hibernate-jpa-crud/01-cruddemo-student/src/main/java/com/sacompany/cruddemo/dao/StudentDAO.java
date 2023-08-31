package com.sacompany.cruddemo.dao;

import com.sacompany.cruddemo.entitiy.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);
    Student findById(Integer id);

    List<Student> findAll();
}
