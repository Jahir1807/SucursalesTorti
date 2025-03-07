package com.example.demo.service;

import com.example.demo.model.Area;
import com.example.demo.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaService {

    @Autowired
    private AreaRepository areaRepository;

    public List<Area> getAllAreas() {
        return areaRepository.findAll();
    }

    public Optional<Area> getAreaById(Integer id) {
        return areaRepository.findById(id);
    }

    public Area saveArea(Area area) {
        return areaRepository.save(area);
    }

    public void deleteArea(Integer id) {
        areaRepository.deleteById(id);
    }
}