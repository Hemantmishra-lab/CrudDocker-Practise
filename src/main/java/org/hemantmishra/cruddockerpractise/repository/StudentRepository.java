package org.hemantmishra.cruddockerpractise.repository;

import org.hemantmishra.cruddockerpractise.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {


}
