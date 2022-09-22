package com.ltp.conditionals;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConditionalsController {

    @GetMapping(value = "/")
    public String getMethodName(Model model) {
        model.addAttribute("sales", 30);
        model.addAttribute("product", "chair");
        return "conditionals";
    }

}
