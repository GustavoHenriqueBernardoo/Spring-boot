package com.ltp.globalsuperstore;

import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GlobalController {

  Item item = new Item(Constants.CATEGORIES[2], "Laptop", 1.50, 0.50, null);
  List<Item> items = new ArrayList<>();

  @GetMapping("/")
  public String getForm(Model model) {

    model.addAttribute("categories", Constants.CATEGORIES);
    model.addAttribute("item", item);
    return "form";
  }

  @GetMapping("/inventory")
  public String getInventory() {
    return "inventory";
  }

  @PostMapping("/submitItem")
  public String postMethodName(Item item) {
    items.add(item);
    System.out.println(items);
    return "redirect:/inventory";
  }

}
