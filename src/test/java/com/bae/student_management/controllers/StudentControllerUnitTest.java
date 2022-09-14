package com.bae.student_management.controllers;


import com.bae.student_management.entities.Student;
import com.bae.student_management.services.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class StudentControllerUnitTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private StudentService service;

    @Test
    public void createTest() throws Exception {
        //An object for sending in the body of the request
        Student input = new Student("Michael", "Jordan", 16, "07999999999",
                "email@email.com");
        String inputAsJSON = this.mapper.writeValueAsString(input);

        //An object for checking the response
        Student response= new Student(2L, "Michael", "Jordan", 16, "07999999999",
                "email@email.com");
        String responseAsJSON = this.mapper.writeValueAsString(response);

        Mockito.when(service.create(input)).thenReturn(response);

        this.mvc.perform(post("/student/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(inputAsJSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(responseAsJSON));
    }

    @Test
    public void getAllTest() throws Exception {
        //created a list
        List<Student> result = new ArrayList<>();
        //added my expected student to the list
        result.add(new Student(1L, "Michael", "Jordan", 16, "07999999999",
                "email@email.com"));
        //converted that list into JSON
        String resultAsJSON = mapper.writeValueAsString(result);

        Mockito.when(service.getAll()).thenReturn(result);

        this.mvc.perform(get("/student/getAll")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(resultAsJSON));
    }

    @Test
    public void getByIdTest() throws Exception{

        Student result = new Student(1L, "Michael", "Jordan", 16, "07999999999",
                "email@email.com");
        String resultAsJSON = this.mapper.writeValueAsString(result);

        Mockito.when(service.getById(1L)).thenReturn(result);

        this.mvc.perform(get("/student/getById/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(resultAsJSON));
    }

    @Test
    public void getByFirstNameTest() throws Exception {
        //Create a list
        List<Student> result = new ArrayList<>();
        //Adding expected student to the list
        result.add(new Student(1L, "Michael", "Jordan", 16, "07999999999",
                "email@email.com"));
        //Convert that list to JSON
        String resultAsJSON = this.mapper.writeValueAsString(result);

        Mockito.when(service.getByFirstName("Michael")).thenReturn(result);

        mvc.perform(get("/student/getByFirstName/Michael")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(resultAsJSON));
    }

    @Test
    public void getBySecondNameTest() throws Exception {
        //Create a list
        List<Student> result = new ArrayList<>();
        //Adding expected student to the list
        result.add(new Student(1L, "Michael", "Jordan", 16, "07999999999",
                "email@email.com"));
        //Convert that list to JSON
        String resultAsJSON = this.mapper.writeValueAsString(result);

        Mockito.when(service.getBySecondName("Jordan")).thenReturn(result);

        mvc.perform(get("/student/getBySecondName/Jordan")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(resultAsJSON));
    }

    @Test
    public void getByAgeTest() throws Exception {
        //Create a list
        List<Student> result = new ArrayList<>();
        //Adding expected student to the list
        result.add(new Student(1L, "Michael", "Jordan", 16, "07999999999",
                "email@email.com"));
        //Convert that list to JSON
        String resultAsJSON = this.mapper.writeValueAsString(result);

        Mockito.when(service.getByAge(16)).thenReturn(result);

        mvc.perform(get("/student/getByAge/16")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(resultAsJSON));
    }

    @Test
    public void updateTest() throws Exception {

        Student input = new Student(1L, "Mike", "Oxmaul", 15, "07888888888",
                "email@email.com");
        String inputAsJSON = this.mapper.writeValueAsString(input);

        Mockito.when(service.update(1L, input)).thenReturn(input);

        this.mvc.perform(put("/student/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(inputAsJSON))
                .andExpect(status().isAccepted())
                .andExpect(content().json(inputAsJSON));
    }

    @Test
    public void deleteTest() throws Exception {

        Mockito.when(service.remove(1L)).thenReturn(true);

        this.mvc.perform(delete("/student/delete/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

//        this.mvc.perform(MockMvcRequestBuilders
//                        .delete("/student/delete/1"))
//                .andExpect(status().isNoContent());
    }

}

