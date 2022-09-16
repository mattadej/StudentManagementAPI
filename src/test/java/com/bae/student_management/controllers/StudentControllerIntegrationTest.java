package com.bae.student_management.controllers;

import com.bae.student_management.entities.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc //gives us the ability to send mock requests using MockMVC
@Sql(scripts = {"classpath:studentschema.sql", "classpath:studentdata.sql"},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test") //switches to our h2 database
public class StudentControllerIntegrationTest {

    @Autowired
    private MockMvc mvc; //this is for sending mick requests

    @Autowired
    private ObjectMapper mapper; //Is converting to and from JSON data

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

        this.mvc.perform(put("/student/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(inputAsJSON))
                .andExpect(status().isAccepted())
                .andExpect(content().json(inputAsJSON));
    }

    @Test
    public void deleteTest() throws Exception {

        this.mvc.perform(delete("/student/delete/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

//        this.mvc.perform(MockMvcRequestBuilders
//                .delete("/student/delete/1"))
//                .andExpect(status().isNoContent());

    }
}