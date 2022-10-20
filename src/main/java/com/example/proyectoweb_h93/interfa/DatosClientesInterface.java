package com.example.proyectoweb_h93.interfa;

import com.example.proyectoweb_h93.entity.DatosClientesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatosClientesInterface extends CrudRepository <DatosClientesEntity,Integer>{
}
