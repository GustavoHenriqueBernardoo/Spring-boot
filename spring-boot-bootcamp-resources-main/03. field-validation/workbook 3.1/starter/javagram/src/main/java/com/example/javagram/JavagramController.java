package com.example.javagram;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class JavagramController {

  User user = new User("Gustavo", "Bernardo", "GB", "gustavo.bernardo@gmail.com", null);

  @GetMapping("/")
  public String getForm(Model model) {
    model.addAttribute("user", user);
    return "sign-up";
  }

  @GetMapping("/result")
  public String getResult() {
    return "result";
  }

  @PostMapping("/submitItem")
  public String submitForm(User user) {
    // TODO: process POST request

    return "redirect:/result";
  }

}
