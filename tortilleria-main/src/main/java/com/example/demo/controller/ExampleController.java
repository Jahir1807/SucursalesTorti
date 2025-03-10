package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExampleController {

    @GetMapping("/examplejs")
    public String examplejs(Model model) {
        model.addAttribute("title", "Ejemplo Dinámico con Estilo");
        return "examplejs";
    }
}
