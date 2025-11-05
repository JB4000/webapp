package com.danmarkmodmadspild.webapp.minRejseController;



import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MinRejseController {


    @GetMapping("/minRejse")
    public String minRejse(){
        return "home/minRejse";
    }


}
