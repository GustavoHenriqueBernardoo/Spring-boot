package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

  public List<Student> getStudents() {
    return List.of(
        new Student(1L, "Gustavo", "gustavo.b@gmail.com", LocalDate.of(1994, Month.MARCH, 21), 28));
  }
}
