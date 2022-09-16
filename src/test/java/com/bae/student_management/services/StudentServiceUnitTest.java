package com.bae.student_management.services;

import com.bae.student_management.entities.Student;
import com.bae.student_management.repos.StudentRepo;
import com.bae.student_management.services.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentServiceUnitTest {

    @Autowired
    private StudentService service;

    //Mocking the repository class, so we don't have to rely on the class itself
    @MockBean
    private StudentRepo repo;

//    @Test
//    public void createEmployeeTest() {
//        Student input = new Student("Michael", "Jordan", 16, "07999999999", "email@qa.com");
//        Student output = new Student(1L, "Michael", "Jordan", 16, "07999999999", "email@qa.com");
//
//        Mockito.when(this.repo.save(input)).thenReturn(output);
//
//        assertEquals(output, this.service.create(input));
//
//        Mockito.verify(this.repo, Mockito.times(1)).save(input);
//    }

    @Test
    public void getAllTest() {
        Student student = new Student("Michael", "Jordan", 16, "07999999999", "email@qa.com");

        List<Student> students = new ArrayList<>();
        students.add(student);

        Mockito.when(this.repo.findAll()).thenReturn(students);

        assertEquals(students, this.service.getAll());

        Mockito.verify(this.repo, Mockito.times(1)).findAll();
    }

    @Test
    public void getByIdTest() {

        Optional<Student> optionalOutput = Optional.of(new Student(1L, "Michael", "Jordan", 16, "07999999999", "email@qa.com"));
        Student output = new Student(1L, "Michael", "Jordan", 16, "07999999999", "email@qa.com");

        Mockito.when(this.repo.findById(Mockito.anyLong())).thenReturn(optionalOutput);

        assertEquals(output, this.service.getById(Mockito.anyLong()));

        Mockito.verify(this.repo, Mockito.times(1)).findById(Mockito.anyLong());
    }

    @Test
    public void deleteTrueTest() {
        Mockito.when(this.repo.existsById(1L)).thenReturn(false);

        assertTrue(this.service.remove(1L));

        Mockito.verify(this.repo, Mockito.times(1)).deleteById(1L);
        Mockito.verify(this.repo, Mockito.times(1)).existsById(1L);
    }

}
