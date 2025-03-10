package com.example.demo.controller;

import com.example.demo.model.Rol;
import com.example.demo.model.Area;
import com.example.demo.service.RolService;
import com.example.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @Autowired
    private AreaService areaService;

    @GetMapping
    public String getAllRoles(Model model) {
        List<Rol> roles = rolService.getAllRoles();
        model.addAttribute("roles", roles);
        return "roles";
    }

    @GetMapping("/nuevo")
    public String nuevoRol(Model model) {
        model.addAttribute("rol", new Rol());
        model.addAttribute("areas", areaService.getAllAreas()); 
        return "crearRol";
    }

    @PostMapping("/guardar")
    public String guardarRol(@ModelAttribute Rol rol) {
        rolService.saveRol(rol);
        return "redirect:/roles";
    }

    @GetMapping("/editar/{id}")
    public String editarRol(@PathVariable Integer id, Model model) {
        Optional<Rol> rol = rolService.getRolById(id);
        if (rol != null) {
            model.addAttribute("rol", rol);
            model.addAttribute("areas", areaService.getAllAreas()); 
            return "editarRol";
        }
        return "redirect:/roles";
    }

    @PostMapping("/actualizar")
    public String actualizarRol(@ModelAttribute Rol rol) {
        rolService.saveRol(rol);
        return "redirect:/roles";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarRol(@PathVariable Integer id) {
        rolService.deleteRol(id);
        return "redirect:/roles";
    }
}
