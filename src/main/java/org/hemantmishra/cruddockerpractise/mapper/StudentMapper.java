package org.hemantmishra.cruddockerpractise.mapper;

import org.hemantmishra.cruddockerpractise.dto.StudentRequestDTO;
import org.hemantmishra.cruddockerpractise.dto.StudentResponseDTO;
import org.hemantmishra.cruddockerpractise.entity.Student;

public class StudentMapper {

    public static Student toEntity(StudentRequestDTO studentRequestDTO){
        return new Student(null,studentRequestDTO.getName(), studentRequestDTO.getRollNo());
    }

    public static StudentResponseDTO toStudentResponse(Student student){
        return new StudentResponseDTO(student.getId(),student.getName(),student.getRollNo());
    }
}
