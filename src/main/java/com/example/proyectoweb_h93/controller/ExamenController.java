package com.example.proyectoweb_h93.controller;


import com.example.proyectoweb_h93.entity.CategoriaEntity;
import com.example.proyectoweb_h93.entity.ExamenEntity;
import com.example.proyectoweb_h93.service.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/examen")
@CrossOrigin ("*")
public class ExamenController {
    @Autowired
    private ExamenService examenService;

    @PostMapping("/agregar")
    public ResponseEntity<ExamenEntity> guardarExamen(@RequestBody ExamenEntity examen){
        return ResponseEntity.ok(examenService.agregarExamen(examen));
    }

    @PutMapping("/modificar")
    public ResponseEntity<ExamenEntity> actualizarExamen(@RequestBody ExamenEntity examen){
        return ResponseEntity.ok(examenService.actualizarExamen(examen));
    }

    @GetMapping("/obtener")
    public ResponseEntity<?> listarExamenes(){
        return ResponseEntity.ok(examenService.obtenerExamenes());
    }

    @GetMapping("/obtener/{examenId}")
    public ExamenEntity listarExamen(@PathVariable("examenId") Long examenId){
        return examenService.obtenerExamen(examenId);
    }

    @DeleteMapping("/eliminar/{examenId}")
    public void eliminarExamen(@PathVariable("examenId") Long examenId){
        examenService.eliminarExamen(examenId);
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<ExamenEntity> listarExamenesDeUnaCategoria(@PathVariable("categoriaId") Long categoriaId){
        CategoriaEntity categoria = new CategoriaEntity();
        categoria.setCategoriaId(categoriaId);
        return examenService.listarExamenesDeUnaCategoria(categoria);
    }

    @GetMapping("/activo")
    public List<ExamenEntity> listarExamenesActivos(){
        return examenService.obtenerExamenesActivos();
    }

    @GetMapping("/categoria/activo/{categoriaId}")
    public List<ExamenEntity> listarExamenesActivosDeUnaCategoria(@PathVariable("categoriaId") Long categoriaId){
        CategoriaEntity categoria = new CategoriaEntity();
        categoria.setCategoriaId(categoriaId);
        return examenService.obtenerExamenesActivosDeUnaCategoria(categoria);
    }
}
