package com.example.proyectoweb_h93.interfa;

import com.example.proyectoweb_h93.entity.CuentaClienteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface CuentaClienteInterface extends CrudRepository <CuentaClienteEntity,Integer> {
}
