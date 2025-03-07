package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RHController {

    @GetMapping("/gestionRH")
    public String gestionRH() {
        return "gestionRH"; 
    }
    
    @GetMapping("/index")
    public String index() {
        return "index";  
    }
}