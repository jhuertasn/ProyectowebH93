package com.example.proyectoweb_h93.entity;

public class jwtResponse {
    // se crea la variable token
    String token;
//generamos su get y set
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
// generamos su constructor

    // esto se cambio ya que si no se colocaba String token daba error en el authcontroller
    public jwtResponse (String token){
        this.token = token;
    }

    public jwtResponse (){

    }


}
