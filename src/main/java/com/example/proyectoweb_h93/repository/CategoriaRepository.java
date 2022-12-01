package com.example.proyectoweb_h93.repository;

import com.example.proyectoweb_h93.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends CrudRepository<CategoriaEntity,Integer>{
}
