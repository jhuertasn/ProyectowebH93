package com.example.proyectoweb_h93.controller;


import com.example.proyectoweb_h93.entity.ExamenEntity;
import com.example.proyectoweb_h93.entity.PreguntaEntity;
import com.example.proyectoweb_h93.service.ExamenService;
import com.example.proyectoweb_h93.service.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/preguntas")
@CrossOrigin ("*")
public class PreguntasController {
    @Autowired
    private PreguntaService preguntaService;

    @Autowired
    private ExamenService examenService;

    @PostMapping("/agregar")
    public ResponseEntity<PreguntaEntity> guardarPregunta(@RequestBody PreguntaEntity pregunta){
        return ResponseEntity.ok(preguntaService.agregarPregunta(pregunta));
    }

    @PutMapping("/modificar")
    public ResponseEntity<PreguntaEntity> actualizarPregunta(@RequestBody PreguntaEntity pregunta){
        return ResponseEntity.ok(preguntaService.actualizarPregunta(pregunta));
    }

    @GetMapping("/examen/{examenId}")
    public ResponseEntity<?> listarPreguntasDelExamen(@PathVariable("examenId") Long examenId){
        ExamenEntity examen = examenService.obtenerExamen(examenId);
        Set<PreguntaEntity> preguntas = examen.getPreguntas();

        List examenes = new ArrayList(preguntas);
        if(examenes.size() > Integer.parseInt(examen.getNumeroDePreguntas())){
            examenes = examenes.subList(0,Integer.parseInt(examen.getNumeroDePreguntas() + 1));
        }

        Collections.shuffle(examenes);
        return ResponseEntity.ok(examenes);
    }

    @GetMapping("/obtener/{preguntaId}")
    public PreguntaEntity listarPreguntaPorId(@PathVariable("preguntaId") Long preguntaId){
        return preguntaService.obtenerPregunta(preguntaId);
    }

    @DeleteMapping("/eliminar/{preguntaId}")
    public void eliminarPregunta(@PathVariable("preguntaId") Long preguntaId){
        preguntaService.eliminarPregunta(preguntaId);
    }

    @GetMapping("/examen/todos/{examenId}")
    public ResponseEntity<?> listarPreguntaDelExamenComoAdministrador(@PathVariable("examenId") Long examenId){
        ExamenEntity examen = new ExamenEntity();
        examen.setExamenId(examenId);
        Set<PreguntaEntity> preguntas = preguntaService.obtenerPreguntasDelExamen(examen);
        return ResponseEntity.ok(preguntas);
    }

    @PostMapping("/evaluar-examen")
    public ResponseEntity<?> evaluarExamen(@RequestBody List<PreguntaEntity> preguntas){
        double puntosMaximos = 0;
        Integer respuestasCorrectas = 0;
        Integer intentos = 0;

        for(PreguntaEntity p : preguntas){
            PreguntaEntity pregunta = this.preguntaService.listarPregunta(p.getPreguntaId());
            if(pregunta.getRespuesta().equals(p.getRespuestaDada())){
                respuestasCorrectas ++;
                double puntos = Double.parseDouble(preguntas.get(0).getExamen().getPuntosMaximos())/preguntas.size();
                puntosMaximos += puntos;
            }
            if(p.getRespuestaDada() != null){
                intentos ++;
            }
        }

        Map<String,Object> respuestas = new HashMap<>();
        respuestas.put("puntosMaximos",puntosMaximos);
        respuestas.put("respuestasCorrectas",respuestasCorrectas);
        respuestas.put("intentos",intentos);
        return ResponseEntity.ok(respuestas);
    }
}
