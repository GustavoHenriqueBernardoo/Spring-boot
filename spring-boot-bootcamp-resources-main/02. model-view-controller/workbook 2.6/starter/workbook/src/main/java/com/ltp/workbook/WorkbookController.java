package com.ltp.workbook;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorkbookController {

    @GetMapping(value = "/")
    public String getMethodName(Model model) {
        model.addAttribute("budget", 10000);
        model.addAttribute("make", "Subaru");
        return "dealership";
    }
}