package com.example.proyectoweb_h93.entity;

public class jwtRequest {
   //creamos la variable username y password
    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
// enviamos usuario y contraseña

    //se crea el constructor jwtRequest
    public jwtRequest (){

    }
}
