package com.example.proyectoweb_h93.entity;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {
 // este es el metodo para encriptar el token y utilizar el metodo de encriptacion
    private String authority;

    public Authority (String authority){
        this.authority = authority;
    }



    @Override
    public  String getAuthority(){
        //estaba en null
        return this.authority;
    }
}
