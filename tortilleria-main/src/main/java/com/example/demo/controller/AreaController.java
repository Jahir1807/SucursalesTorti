package com.example.demo.controller;

import com.example.demo.model.Area;
import com.example.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/areas")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping
    public String getAllAreas(Model model) {
        model.addAttribute("areas", areaService.getAllAreas());
        return "areas"; 
    }

    @PostMapping("/guardar")
    @ResponseBody
    public Area saveArea(@RequestBody Area area) {
        return areaService.saveArea(area);
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseBody
    public String deleteArea(@PathVariable Integer id) {
        areaService.deleteArea(id);
        return "Área eliminada correctamente";
    }
}