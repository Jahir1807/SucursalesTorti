package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AuthController {

    private Map<String, String> usuarios = new HashMap<>();

    @GetMapping("/loginn")
    public String loginPage() {
        return "loginn";
    }

    @PostMapping("/loginn")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        if (usuarios.containsKey(username) && usuarios.get(username).equals(password)) {
            model.addAttribute("username", username);
            return "index";  
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "loginn";
        }
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, Model model) {
        if (usuarios.containsKey(username)) {
            model.addAttribute("error", "El usuario ya existe");
            return "register";
        } else {
            usuarios.put(username, password);
            model.addAttribute("message", "Registro exitoso, ahora puedes iniciar sesión");
            return "loginn";
        }
    }
}
