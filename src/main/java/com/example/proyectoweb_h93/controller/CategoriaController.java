package com.example.proyectoweb_h93.controller;

import com.example.proyectoweb_h93.entity.CategoriaEntity;
import com.example.proyectoweb_h93.entity.CuentaClienteEntity;
import com.example.proyectoweb_h93.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaRepository CategoriaRepository;
    @GetMapping
    public List<CategoriaEntity> busquedaCategoria (){
        return (List<CategoriaEntity>) CategoriaRepository.findAll();
    }

    @PostMapping
    public void crearcategoria (@RequestBody CategoriaEntity categoriaClient){
        CategoriaRepository.save(categoriaClient);
    }
}
