package com.bae.student_management.controllers;

import com.bae.student_management.entities.Student;
import com.bae.student_management.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

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

    // Get requests (READ)
    @GetMapping("/getAll")
    // We return a list because the readAll method in the service class returns a
    // list also
    public ResponseEntity<List<Student>> getAll() {
        return new ResponseEntity<List<Student>>(this.service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    // @PathVariable allows us to pass a variable (in this case ID) to the path &
    // service.readById method
    public ResponseEntity<Student> getById(@PathVariable long id) {
        return new ResponseEntity<Student>(this.service.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getByFirstName/{firstName}")
    public List<Student> getByFirstName(@PathVariable String firstName) {
        return service.getByFirstName(firstName);
    }

    @GetMapping("/getBySecondName/{secondName}")
    public List<Student> getBySecondName(@PathVariable String secondName) {
        return service.getBySecondName(secondName);
    }

    @GetMapping("/getBySecondName/{secondName}")
    public List<Student> getByAge(@PathVariable int age) {
        return service.getByAge(age);
    }

    // Put requests (UPDATE)
    @PutMapping("/update/{id}")
    // update requires both RequestBody and PathVariable as it takes in the id, and
    // also passes through the new object information
    public ResponseEntity<Student> update(@PathVariable long id, @RequestBody Student students) {
        return new ResponseEntity<Student>(this.service.update(id, students), HttpStatus.ACCEPTED);
    }

    // Delete requests (DELETE)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> remove(@PathVariable long id) {
        //Ternary operator, IF  service.delete is successful, return no content
        //ELSE return not found
        return (this.service.remove(id)) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
    }

}