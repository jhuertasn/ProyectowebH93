package com.example.proyectoweb_h93.repository;

import com.example.proyectoweb_h93.entity.CategoriaEntity;
import com.example.proyectoweb_h93.entity.ExamenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamenRepository extends JpaRepository<ExamenEntity,Long> {
    List<ExamenEntity> findByCategoria(CategoriaEntity categoria);

    List<ExamenEntity> findByActivo(Boolean estado);

    List<ExamenEntity> findByCategoriaAndActivo(CategoriaEntity categoria, Boolean estado);
}
