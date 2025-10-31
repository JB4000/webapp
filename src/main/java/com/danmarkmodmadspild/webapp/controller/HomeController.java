package com.danmarkmodmadspild.webapp.controller;


import com.danmarkmodmadspild.webapp.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


@Controller
public class HomeController {
    @Autowired
    HomeService homeService;


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("Problem", homeService.getProblemText());
        model.addAttribute("Solution", homeService.getSolutionText());
        return "home/index";
    }
}
