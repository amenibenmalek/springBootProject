package com.benmalek.springBootApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class GradeController {

  @GetMapping("/grades")
  public String sayHello(Model model)
  {
    Grade grade = new Grade("harry","spring","12");
    model.addAttribute("grade",grade);
    return "grades";
  }

}
