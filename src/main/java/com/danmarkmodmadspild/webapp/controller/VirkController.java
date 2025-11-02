package com.danmarkmodmadspild.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


@Controller
public class VirkController {


    @GetMapping("/regVirk")
    public String regVirk() {

        return "home/regVirk";
    }


}
