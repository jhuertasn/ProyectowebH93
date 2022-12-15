package com.example.proyectoweb_h93.controller;

import com.example.proyectoweb_h93.entity.CategoriaEntity;
import com.example.proyectoweb_h93.entity.ExamenEntity;
import com.example.proyectoweb_h93.service.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/examen")
@CrossOrigin ("*")
public class ExamenController {
    @Autowired
    private ExamenService examenService;
    @GetMapping
    public List<ExamenEntity> busquedaexamen (){
        return (List<ExamenEntity>) examenService.obtenerExamenes();
    }

    @PostMapping ("/agregar")
    public void creaexamen (@RequestBody ExamenEntity examenClient){
        examenService.agregarExamen(examenClient);
    }

    @PutMapping
    public void actualizarExamen (@RequestBody ExamenEntity examenClient){
        examenService.actualizarExamen(examenClient);
    }

    @GetMapping (value = "{idexamen}")
    public ExamenEntity obtenerExamenId (@PathVariable("idexamen")Long idexamen){
        return examenService.obtenerExamen(idexamen);
    }

    /*@DeleteMapping (value = "/eliminar/{idexamen}")
    //capturando la variable id
    public void eliminarExamen (@PathVariable ("idexamen") Long examenId){
        //Eliminas por id
        examenService.eliminarExamen(examenId);
    }


    //revisar estos request con el profesor
    @GetMapping ("/listar/examen/{idCategoria}")
    public List<ExamenEntity> listarExamenesDeUnaCategoriaid(@PathVariable ("idCategoria") CategoriaEntity categoria) {
        return this.examenService.listarExamenesDeUnaCategoria(categoria);
    }

    @GetMapping
    public List<ExamenEntity> obtenerExamenesActivos() {
        for (ExamenEntity examen : examenService.obtenerExamenes()) {
            if (examen.isActivo()) {
                examenService.obtenerExamenesActivos();
            }
        }
        return this.examenService.obtenerExamenesActivos();
    }



    @GetMapping ("/listar/examen/{idCategoria}")
    public List<ExamenEntity> obtenerExamenesActivosDeUnaCategoria(@PathVariable ("idCategoria") CategoriaEntity categoria) {
        for(ExamenEntity examen :examenService.obtenerExamenes()){
            if(examen.isActivo()&& examen.getCategoria().equals("idCategoria")){
                examenService.obtenerExamenes().add(examen);
            }
        }
        return examenService.obtenerExamenesActivosDeUnaCategoria(categoria);
    }*/
}
