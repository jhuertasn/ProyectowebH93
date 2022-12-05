package com.example.proyectoweb_h93.service;

import com.example.proyectoweb_h93.entity.CategoriaEntity;
import com.example.proyectoweb_h93.entity.ExamenEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface ExamenService {
    ExamenEntity agregarExamen(ExamenEntity examen);

    ExamenEntity actualizarExamen(ExamenEntity examen);

    Set<ExamenEntity> obtenerExamenes();

    ExamenEntity obtenerExamen(Long examenId);

    void eliminarExamen(Long examenId);

    List<ExamenEntity> listarExamenesDeUnaCategoria(CategoriaEntity categoria);

    List<ExamenEntity> obtenerExamenesActivos();

    List<ExamenEntity> obtenerExamenesActivosDeUnaCategoria(CategoriaEntity categoria);
}
