package org.hemantmishra.cruddockerpractise.service;

import jakarta.persistence.Lob;
import org.hemantmishra.cruddockerpractise.dto.StudentRequestDTO;
import org.hemantmishra.cruddockerpractise.dto.StudentResponseDTO;
import org.hemantmishra.cruddockerpractise.entity.Student;
import org.hemantmishra.cruddockerpractise.mapper.StudentMapper;
import org.hemantmishra.cruddockerpractise.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public StudentResponseDTO createStudent(StudentRequestDTO studentRequestDTO){
        Student createdStudent = studentRepository.save(StudentMapper.toEntity(studentRequestDTO));
        return StudentMapper.toStudentResponse(createdStudent);
    }

    public Student getStudent(Long id){
        Student student = studentRepository.getById(id);
        return student;
    }
}
