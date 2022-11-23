package com.example.proyectoweb_h93.repository;

import com.example.proyectoweb_h93.entity.DatosClientesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatosClientesRepository extends CrudRepository<DatosClientesEntity,Integer>{
}
