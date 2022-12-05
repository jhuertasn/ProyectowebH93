package com.example.proyectoweb_h93.service;

import com.example.proyectoweb_h93.entity.ExamenEntity;
import com.example.proyectoweb_h93.entity.PreguntaEntity;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface PreguntaService {
    PreguntaEntity agregarPregunta(PreguntaEntity pregunta);

    PreguntaEntity actualizarPregunta(PreguntaEntity pregunta);

    Set<PreguntaEntity> obtenerPreguntas();

    PreguntaEntity obtenerPregunta(Long preguntaId);

    Set<PreguntaEntity> obtenerPreguntasDelExamen(ExamenEntity examen);

    void eliminarPregunta(Long preguntaId);

    PreguntaEntity listarPregunta(Long preguntaId);
}
