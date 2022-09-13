package com.bae.student_management.services;

import com.bae.student_management.exceptions.StudentNotFoundException;
import com.bae.student_management.repos.StudentRepo;
import com.bae.student_management.entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepo repo;

    public StudentService(StudentRepo repo) {
        super();
        this.repo = repo;
    }

    // Post requests (CREATE)
    public Student create(Student input) {
        return repo.saveAndFlush(input);
    }

    // Get requests (READ)
    public List<Student> getAll() {
        return repo.findAll();
    }

    public Student getById(long id) {
        return repo.findById(id).orElseThrow(StudentNotFoundException::new);
    }

    public List<Student> getByFirstName(String firstName) {
        return repo.findStudentByFirstName(firstName);
    }

    public List<Student> getBySecondName(String secondName) {
        return repo.findStudentBySecondName(secondName);
    }

    // Put requests (UPDATE)
    public Student update(long id, Student students) {
        Student existing = repo.findById(id).orElseThrow(StudentNotFoundException::new);

        existing.setFirstName(students.getFirstName());
        existing.setSecondName(students.getSecondName());
        existing.setAge(students.getAge());
        existing.setEmail(students.getEmail());
        existing.setContactNumber(students.getContactNumber());

        return repo.saveAndFlush(existing);
    }

    // Delete requests (DELETE)
    public boolean remove(long id) {
        repo.deleteById(id);
        return !repo.existsById(id);
    }

}
