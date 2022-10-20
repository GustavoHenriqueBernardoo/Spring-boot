package com.ltp.gradesubmission.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltp.gradesubmission.entity.Student;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

  @GetMapping("/student")
  public ResponseEntity<Student> getStudent(@PathVariable Long id) {

    return new ResponseEntity<>(HttpStatus.OK);
  }
}
