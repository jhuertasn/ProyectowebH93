package com.example.proyectoweb_h93.service.Implement;

import com.example.proyectoweb_h93.entity.CategoriaEntity;
import com.example.proyectoweb_h93.entity.ExamenEntity;
import com.example.proyectoweb_h93.repository.ExamenRepository;
import com.example.proyectoweb_h93.service.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class ExamenServiceImpl implements ExamenService {
    @Autowired
    private ExamenRepository examenRepository;

    @Override
    public ExamenEntity agregarExamen(ExamenEntity examen) {
        return examenRepository.save(examen);
    }

    @Override
    public ExamenEntity actualizarExamen(ExamenEntity examen) {
        return examenRepository.save(examen);
    }

    @Override
    public Set<ExamenEntity> obtenerExamenes() {
        return new LinkedHashSet<>(examenRepository.findAll());
    }

    @Override
    public ExamenEntity obtenerExamen(Long examenId) {
        return examenRepository.findById(examenId).get();
    }

    @Override
    public void eliminarExamen(Long examenId) {
        ExamenEntity examen = new ExamenEntity();
        examen.setExamenId(examenId);
        examenRepository.delete(examen);
    }

    @Override
    public List<ExamenEntity> listarExamenesDeUnaCategoria(CategoriaEntity categoria) {
        return this.examenRepository.findByCategoria(categoria);
    }

    @Override
    public List<ExamenEntity> obtenerExamenesActivos() {
        return examenRepository.findByActivo(true);
    }

    @Override
    public List<ExamenEntity> obtenerExamenesActivosDeUnaCategoria(CategoriaEntity categoria) {
        return examenRepository.findByCategoriaAndActivo(categoria,true);
    }

}
