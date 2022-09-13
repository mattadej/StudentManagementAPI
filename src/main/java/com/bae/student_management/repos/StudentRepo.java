package com.bae.student_management.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bae.student_management.entities.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    // Find by firstName. This will return multiple records.
    List<Student> findStudentByFirstName(String firstName);

    // Find by secondName. This will return multiple records.
    List<Student> findStudentBySecondName(String secondName);

}