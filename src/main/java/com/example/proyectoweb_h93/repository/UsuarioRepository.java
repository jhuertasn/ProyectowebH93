package com.example.proyectoweb_h93.repository;

import com.example.proyectoweb_h93.entity.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository <UsuariosEntity,Integer> {
// aqui esta el error del profe no cambiar a findByUsername
    // se tiene que usar la misma sintaxis del jpa
    public UsuariosEntity findByUsername(String username);
}
