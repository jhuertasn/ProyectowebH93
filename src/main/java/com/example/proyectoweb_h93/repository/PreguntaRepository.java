package com.example.proyectoweb_h93.repository;

import com.example.proyectoweb_h93.entity.ExamenEntity;
import com.example.proyectoweb_h93.entity.PreguntaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PreguntaRepository extends JpaRepository<PreguntaEntity,Long> {
    Set<PreguntaEntity> findByExamen(ExamenEntity examen);
}
