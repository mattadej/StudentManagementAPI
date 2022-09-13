package com.bae.student_management.services;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentService {

    private StudentService service;

    public StudentController(StudentService service) {
        super();
        this.service = service;
    }

    // Post requests (CREATE)
    @PostMapping("/create")
    // @RequestBody allows us to pass through an object/data when we make the
    // request
    public ResponseEntity<Student> create(@RequestBody Student students){
        return new ResponseEntity<Student>(this.service.create(students), HttpStatus.CREATED);
    }




}
