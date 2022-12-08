package com.example.proyectoweb_h93.controller;

import com.example.proyectoweb_h93.entity.ExamenEntity;
import com.example.proyectoweb_h93.entity.PreguntaEntity;
import com.example.proyectoweb_h93.repository.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pregunta")
@CrossOrigin ("*")
public class PreguntaController {
    @Autowired
    private PreguntaRepository PreguntaRepository;
    @GetMapping
    public List<PreguntaEntity> busquedaPregunta (){
        return (List<PreguntaEntity>) PreguntaRepository.findAll();
    }

    @PostMapping
    public void crearpregunta (@RequestBody PreguntaEntity preguntaClient){
        PreguntaRepository.save(preguntaClient);
    }
}
