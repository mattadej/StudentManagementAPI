package com.bae.student_management.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "A student does not exist with that ID")
public class StudentNotFoundException extends NoSuchElementException{
}
