package com.ltp.gradesubmission;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GradeController {

  List<Grade> studentGrades = Arrays.asList(
      new Grade("John Doe", "Potions", "-C"),
      new Grade("Ronaldo", "Potions", "-A"),
      new Grade("Harry", "Defense Against the Dark Arts", "+A")

  );

  @GetMapping("/grades")
  public String getGrades(Model model) {

    model.addAttribute("grades", studentGrades);
    return "grades";
  }
}
