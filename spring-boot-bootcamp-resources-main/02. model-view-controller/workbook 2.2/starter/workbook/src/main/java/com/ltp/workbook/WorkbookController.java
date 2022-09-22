package com.ltp.workbook;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WorkbookController {

    @GetMapping("/")
    public ModelAndView getShows() {
        // model.addAttribute("show", new Show("Breaking Bad", "Ozymandias", 10.0));
        // model.addAttribute("show2", new Show("Attack on Titan", "Hero", 9.9));
        // model.addAttribute("show3", new Show("Attack on Titan", "Perfect Game",
        // 9.9));
        // model.addAttribute("show4", new Show("Star Wars: The Clone Wars", "Victory
        // and Death", 9.9));
        // model.addAttribute("show5", new Show("Mr. Robot", "407 Proxy Authentication
        // Required", 9.9));

        // Old way of doing, instead of using model and pass in Model model to
        // getShows()
        Map<String, Show> model = new HashMap<>();

        model.put("first", new Show("Breaking Bad", "Ozymandias", 10.0));
        model.put("second", new Show("Attack on Titan", "Perfect Game", 9.9));
        model.put("third", new Show("Star Wars: The Clone Wars", "Victory and Death", 9.9));
        model.put("fourth", new Show("Breaking Bad", "Ozymandias", 10.0));
        model.put("fifth", new Show("Breaking Bad", "Ozymandias", 10.0));

        return new ModelAndView("shows", model);
    }

}
