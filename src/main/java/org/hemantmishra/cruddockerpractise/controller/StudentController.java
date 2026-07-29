package org.hemantmishra.cruddockerpractise.controller;

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
    public ResponseEntity<Student> createStudent(@RequestBody  Student student){
        System.out.println("Hello Sir");
        return ResponseEntity.status(200).body(studentService.createStudent(student));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        return ResponseEntity.status(201).body(studentService.getStudent(id));
    }
}
