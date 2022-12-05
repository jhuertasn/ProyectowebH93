package com.example.proyectoweb_h93.service;

import com.example.proyectoweb_h93.entity.CategoriaEntity;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public interface CategoriaService {
    CategoriaEntity agregarCategoria(CategoriaEntity categoria);

    CategoriaEntity actualizarCategoria(CategoriaEntity categoria);

    Set<CategoriaEntity> obtenerCategorias();

    CategoriaEntity obtenerCategoria(Long categoriaId);

    void eliminarCategoria(Long categoriaId);
}
