package org.hemantmishra.cruddockerpractise.controller;

import org.hemantmishra.cruddockerpractise.dto.StudentRequestDTO;
import org.hemantmishra.cruddockerpractise.dto.StudentResponseDTO;
import org.hemantmishra.cruddockerpractise.entity.Student;
import org.hemantmishra.cruddockerpractise.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResponseDTO> createStudent(@RequestBody StudentRequestDTO studentRequestDTO){
        System.out.println("Hello Sir");
        return ResponseEntity.status(200).body(studentService.createStudent(studentRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        return ResponseEntity.status(201).body(studentService.getStudent(id));
    }
}
