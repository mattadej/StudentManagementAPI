package com.bae.student_management.entities;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentTest {

//    @Test
//    public void testEquals() {
//        EqualsVerifier.forClass(Student.class).usingGetClass().verify();
//
//    }

    @Test
    public void getAndSetTest() {
        Student student = new Student();

        student.setId(1);
        student.setFirstName("Michael");
        student.setSecondName("Jordan");
        student.setAge(16);
        student.setContactNumber("07999999999");
        student.setEmail("email@qa.com");

        assertNotNull(student.getId());
        assertNotNull(student.getFirstName());
        assertNotNull(student.getSecondName());
        assertNotNull(student.getAge());
        assertNotNull(student.getContactNumber());
        assertNotNull(student.getEmail());

        assertEquals(student.getId(), 1);
        assertEquals(student.getFirstName(), "Michael");
        assertEquals(student.getSecondName(), "Jordan");
        assertEquals(student.getAge(), 16);
        assertEquals(student.getContactNumber(), "07999999999");
        assertEquals(student.getEmail(), "email@qa.com");

    }

    @Test
    public void allArgsConstructor() {
        Student student = new Student( 1L,"Michael", "Jordan", 16, "07999999999", "email@qa.com");

        assertNotNull(student.getId());
        assertNotNull(student.getFirstName());
        assertNotNull(student.getSecondName());
        assertNotNull(student.getAge());
        assertNotNull(student.getContactNumber());
        assertNotNull(student.getEmail());

        assertEquals(student.getId(), 1L);
        assertEquals(student.getFirstName(), "Michael");
        assertEquals(student.getSecondName(), "Jordan");
        assertEquals(student.getAge(), 16);
        assertEquals(student.getContactNumber(), "07999999999");
        assertEquals(student.getEmail(), "email@qa.com");


    }

    @Test
    public void noIDConstructor() {
        Student student = new Student("Michael", "Jordan", 16, "07999999999", "email@qa.com");

        assertNotNull(student.getId());
        assertNotNull(student.getFirstName());
        assertNotNull(student.getSecondName());
        assertNotNull(student.getAge());
        assertNotNull(student.getContactNumber());
        assertNotNull(student.getEmail());


        assertEquals(student.getId(), 0);
        assertEquals(student.getFirstName(), "Michael");
        assertEquals(student.getSecondName(), "Jordan");
        assertEquals(student.getAge(), 16);
        assertEquals(student.getContactNumber(), "07999999999");
        assertEquals(student.getEmail(), "email@qa.com");
    }

}
