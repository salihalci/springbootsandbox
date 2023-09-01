package com.sacompany.cruddemo.dao;

import com.sacompany.cruddemo.entitiy.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;


    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {

        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by firstName DESC", Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student where lastName=: theData", Student.class);


        //Set query parameters
        theQuery.setParameter("theData", lastName);
        //execute and return list
        return theQuery.getResultList();


    }

    @Override
    @Transactional
    public void updateStudent(Student theStudent) {

        entityManager.merge(theStudent);

    }

    @Override
    @Transactional
    public int updateAllStudents(String email) {
        Query query = entityManager.createQuery("UPDATE Student SET email='salihalci@gmail.com'");
        int rowNums = 0;
        rowNums = query.executeUpdate();
        return rowNums;
    }

    @Override
    @Transactional
    public void deleteStudent(Integer id) {
        Student student = entityManager.find(Student.class,id);
        entityManager.remove(student);

    }

    @Override
    @Transactional
    public int deleteStudentByLasName(String lastName) {
        Query query=entityManager.createQuery("Delete from Student where lastName="+"'"+lastName+"'");
        int result = query.executeUpdate();
        return result;
    }

    @Override
    @Transactional
    public int deleteAllStudents() {
        Query query = entityManager.createQuery("DELETE From Student");
        int result =0;
        result = query.executeUpdate();

        return result;
    }
}
