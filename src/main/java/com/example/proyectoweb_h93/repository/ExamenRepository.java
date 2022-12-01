package com.example.proyectoweb_h93.repository;

import com.example.proyectoweb_h93.entity.ExamenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamenRepository extends CrudRepository<ExamenEntity,Integer> {
}
