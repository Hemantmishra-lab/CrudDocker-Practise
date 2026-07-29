package org.hemantmishra.cruddockerpractise.service;

import jakarta.persistence.Lob;
import org.hemantmishra.cruddockerpractise.entity.Student;
import org.hemantmishra.cruddockerpractise.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student){
        Student createdStudent = studentRepository.save(student);
        return createdStudent;
    }

    public Student getStudent(Long id){
        Student student = studentRepository.getById(id);
        return student;
    }
}
