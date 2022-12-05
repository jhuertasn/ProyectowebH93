package com.example.proyectoweb_h93.controller;


import com.example.proyectoweb_h93.entity.CategoriaEntity;

import com.example.proyectoweb_h93.service.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;
    @GetMapping("/listar")
    //respuesta del response es tipo Json
    public ResponseEntity<?> listarcategoria (){
        return ResponseEntity.ok(categoriaService.obtenerCategorias());
    }

    @GetMapping("/listar/{idCategoria}")
    //respuesta del response es tipo Json
    public CategoriaEntity listarcategoriaId (@PathVariable ("idCategoria")Long idCategoria){
        return categoriaService.obtenerCategoria(idCategoria);
    }

    @PostMapping ("/agregar")
    public ResponseEntity<CategoriaEntity> agregarCategoria (@RequestBody CategoriaEntity categoria){
        CategoriaEntity categorianueva = categoriaService.agregarCategoria(categoria);
        //le digo a mi response que me envie mi categorianueva
        return ResponseEntity.ok(categorianueva);
    }


}
