package com.bae.student_management.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bae.student_management.entities.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    // Find students by their second name
    List<Student> findStudentByFirstName(String firstName);

    // Find students by their second name
    List<Student> findStudentBySecondName(String secondName);

    //Find students by their age
    List<Student> findStudentByAge(int age);
}