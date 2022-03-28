package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
    @salci Business logic is here
 */
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();

    }



    public void addNewStudent(Student student) {
        System.out.println("Student"+student.toString());

        Optional<Student> expectedStudent =  studentRepository.findStudentByEmail(student.getEmail());

        if(expectedStudent.isPresent()){

           throw new IllegalStateException("email taken");
        } else{

           studentRepository.save(student);
        }

    }

/*
    @GetMapping
    public List<Student> getStudents(){
        return List.of(new Student(
                1L,
                "salih",
                "salih@gmail.com",
                LocalDate.of(2000, Month.DECEMBER,1),
                22
        ));
    }


 */
}
