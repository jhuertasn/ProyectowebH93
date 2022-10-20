package com.example.proyectoweb_h93.service;

import com.example.proyectoweb_h93.entity.UsuariosEntity;
import com.example.proyectoweb_h93.entity.UsuarioRolEntity;

import java.util.Set;

public interface UsuarioServices {
    //Metodo Post
    public UsuariosEntity guardarUsuarioService  (UsuariosEntity usuariosEntity, Set<UsuarioRolEntity> usuarioRolEntity) throws Exception;
    //Metodo Get
    public UsuariosEntity obtenerUsuarioService (String username);
    //chequear idusurios en usuarios entity
    public void eliminarUsuarioService (int idusuarios);
}
