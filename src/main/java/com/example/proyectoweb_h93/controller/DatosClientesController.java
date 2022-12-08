package com.example.proyectoweb_h93.controller;

import com.example.proyectoweb_h93.entity.DatosClientesEntity;
import com.example.proyectoweb_h93.repository.DatosClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Le decimos al java clas que esta clase es un controllador con @RestController//
@RestController
@RequestMapping ("/datocliente")
@CrossOrigin ("*")
public class DatosClientesController {
    //declararamos que esta variable viene con una clase com @Autowired
    @Autowired
    private DatosClientesRepository datosClientesInterface;
    //siempre poner @getMapping para que la clase capture los datos del MySQL
    @GetMapping("/Listar")
    public List<DatosClientesEntity> busquedaDatoCliente (){
        //Con findAll() traemos toda la informacion del objeto datosClientesInterface
        return (List<DatosClientesEntity>) datosClientesInterface.findAll();
    }

    //empieza lo que se avanzo en la clase del viernes 9 de setiembre del 2022

    //create
    @PostMapping("/insertar")
    public void crearDatoCliente (@RequestBody DatosClientesEntity DatCliEnt){
        datosClientesInterface.save(DatCliEnt);
    }

    //UPDATE
    @PutMapping("/modificar")
    public void actualizarDatoCliente (@RequestBody DatosClientesEntity DatCliEnt) {
        datosClientesInterface.save(DatCliEnt);
    }

    //DELETE
    @DeleteMapping (value = "/eliminar/{id}")
    //capturando la variable id
    public void eliminarDatoCliente (@PathVariable ("id") Integer id){
        //Eliminas por id
        datosClientesInterface.deleteById(id);
    }

    //delete y put sin busqueda de datos  o Cambiar el dato que solo nesesito//
    @PutMapping (value = "/modificardato/{id}")
    public ResponseEntity <DatosClientesEntity> actualizarDatoClienteEspecifico (@PathVariable ("id") Integer id, @RequestBody DatosClientesEntity DatCliEntJson) {
        DatosClientesEntity DatClientBD = datosClientesInterface.findById(id).orElseThrow();

        //ApellidoVacio
        if(!(DatCliEntJson.getApellCliente()== null)){
            DatClientBD.setApellCliente(DatCliEntJson.getApellCliente());
        }

        //Correo Vacio
        if(!(DatCliEntJson.getCorreoCliente()== null)){
            DatClientBD.setCorreoCliente(DatCliEntJson.getCorreoCliente());
        }

        //Nombre Vacio
        if(!(DatCliEntJson.getNombCliente() == null)){
            DatClientBD.setNombCliente(DatCliEntJson.getNombCliente());
        }

        //DNI Vacio
        if(!(DatCliEntJson.getDniCliente()== null)){
            DatClientBD.setDniCliente(DatCliEntJson.getDniCliente());
        }

        DatosClientesEntity DatCliEntBDActu = datosClientesInterface.save(DatClientBD);

        return  ResponseEntity.ok(DatCliEntBDActu);
    }

}
