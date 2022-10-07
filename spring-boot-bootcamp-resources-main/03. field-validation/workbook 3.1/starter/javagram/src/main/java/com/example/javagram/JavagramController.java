package com.example.javagram;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JavagramController {

  List<User> users = new ArrayList<>();

  @GetMapping("/")
  public String getForm(Model model) {
    model.addAttribute("user", new User());
    return "sign-up";
  }

  @GetMapping("/result")
  public String getResult() {
    return "result";
  }

  @PostMapping("/submitItem")
  public String handleSubmit(@Valid User user, BindingResult result) {
    // TODO: process POST request

    if (result.hasErrors()) {
      return "sign-up";
    }

    users.add(user);

    return "redirect:/result";
  }

}
