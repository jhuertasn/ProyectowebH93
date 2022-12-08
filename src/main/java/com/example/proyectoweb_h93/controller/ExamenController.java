package com.example.proyectoweb_h93.controller;

import com.example.proyectoweb_h93.entity.ExamenEntity;
import com.example.proyectoweb_h93.repository.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/examen")
@CrossOrigin ("*")
public class ExamenController {
    @Autowired
    private ExamenRepository ExamenRepository;
    @GetMapping
    public List<ExamenEntity> busquedaexamen (){
        return (List<ExamenEntity>) ExamenRepository.findAll();
    }

    @PostMapping
    public void creaexamen (@RequestBody ExamenEntity examenClient){
        ExamenRepository.save(examenClient);
    }
}
