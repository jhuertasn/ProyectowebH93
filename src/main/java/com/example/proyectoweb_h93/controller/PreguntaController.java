package com.example.proyectoweb_h93.controller;

import com.example.proyectoweb_h93.entity.ExamenEntity;
import com.example.proyectoweb_h93.entity.PreguntaEntity;
import com.example.proyectoweb_h93.service.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/preguntas")
@CrossOrigin ("*")
public class PreguntaController {
    @Autowired
    private PreguntaService preguntaService;
    @GetMapping
    public List<PreguntaEntity> busquedapregunta (){
        return (List<PreguntaEntity>) preguntaService.obtenerPreguntas();
    }

    @PostMapping ("/agregar")
    public void creapregunta (@RequestBody PreguntaEntity preguntaClient){
        preguntaService.agregarPregunta(preguntaClient);
    }

    @PutMapping
    public void actualizarPregunta (@RequestBody PreguntaEntity preguntaClient){
        preguntaService.actualizarPregunta(preguntaClient);
    }

    @GetMapping (value = "{idpreguntas}")
    public PreguntaEntity obtenerPregunta (@PathVariable("idpreguntas")Long preguntaId){
        return preguntaService.obtenerPregunta(preguntaId);
    }


    @DeleteMapping (value = "/eliminar/{idpreguntas}")
    //capturando la variable id
    public void eliminarPregunta (@PathVariable ("idpreguntas") Long preguntaId){
        //Eliminas por id
        preguntaService.eliminarPregunta(preguntaId);
    }

    @GetMapping (value = "/listar/{idpreguntas}")
    public PreguntaEntity listarPreguntaId (@PathVariable("idpreguntas")Long preguntaId){
        return preguntaService.listarPregunta(preguntaId);
    }

    //obtener preguntas del examen
    @GetMapping (value = "/listar/{idexamen}")
    public List<PreguntaEntity> obtenerPreguntasDelExamen(@PathVariable ("idexamen") ExamenEntity examen){
        return (List<PreguntaEntity>) preguntaService.obtenerPreguntasDelExamen(examen);
    }
}
