package com.example.demo.controller;

import com.example.demo.model.Area;
import com.example.demo.model.Empleado;
import com.example.demo.model.Rol;
import com.example.demo.service.AreaService;
import com.example.demo.service.EmpleadoService;
import com.example.demo.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private AreaService areaService;

    @Autowired
    private RolService rolService;

    @GetMapping
    public String getAllEmpleados(Model model) {
        List<Empleado> empleados = empleadoService.getAllEmpleados();
        model.addAttribute("empleados", empleados);
        return "empleados";
    }

    @GetMapping("/nuevo")
    public String nuevoEmpleadoForm(Model model) {
        model.addAttribute("empleado", new Empleado());
        model.addAttribute("areas", areaService.getAllAreas());
        model.addAttribute("roles", rolService.getAllRoles());
        return "empleado_form";
    }

    @PostMapping("/guardar")
    public String guardarEmpleado(@ModelAttribute Empleado empleado) {
        empleadoService.saveEmpleado(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/editar/{id}")
    public String editarEmpleadoForm(@PathVariable Integer id, Model model) {
        Optional<Empleado> empleado = empleadoService.getEmpleadoById(id);
        if (empleado.isPresent()) {
            model.addAttribute("empleado", empleado.get());
            model.addAttribute("areas", areaService.getAllAreas());
            model.addAttribute("roles", rolService.getAllRoles());
            return "empleado_form";
        } else {
            return "redirect:/empleados";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEmpleado(@PathVariable Integer id) {
        empleadoService.deleteEmpleado(id);
        return "redirect:/empleados";
    }
}
