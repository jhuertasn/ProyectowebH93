package com.example.proyectoweb_h93.controller;

import com.example.proyectoweb_h93.entity.CuentaClienteEntity;
import com.example.proyectoweb_h93.interfa.CuentaClienteInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/cuentacliente")
@CrossOrigin ("*")
public class CuentaClienteController {
    @Autowired
    private CuentaClienteInterface cuentaClienteInterface;
    @GetMapping
    public List<CuentaClienteEntity> busquedaCuentaCliente (){
        return (List<CuentaClienteEntity>) cuentaClienteInterface.findAll();
    }

    //create
    @PostMapping
    public void crearCuentaCliente (@RequestBody CuentaClienteEntity CuentaClient){
        cuentaClienteInterface.save(CuentaClient);
    }

    //UPDATE
    @PutMapping
    public void actualizarCuentaCliente (@RequestBody CuentaClienteEntity CuentaClient) {
        cuentaClienteInterface.save(CuentaClient);
    }

    //DELETE
    //Hay problemas al borrar con BigInteger por eso se cambio a Integer tanto aqui como en la interfas
    @DeleteMapping (value = "/{CodCuentaCliente}")
    //capturando la variable id
    public void eliminarCuentaCliente (@PathVariable ("CodCuentaCliente") Integer CodCuentaCliente){
        //Eliminas por id
        cuentaClienteInterface.deleteById(CodCuentaCliente);
    }

    //delete y put sin busqueda de datos  o Cambiar el dato que solo nesesito//
    @PutMapping (value = "/{id}")
    public ResponseEntity<CuentaClienteEntity> actualizarCuentaClienteEspecifico (@PathVariable ("id") Integer id, @RequestBody CuentaClienteEntity CuentCliEntJson) {
        CuentaClienteEntity CuentaClientBD = cuentaClienteInterface.findById(id).orElseThrow();

        //Numero de cuenta Vacio
        if(!(CuentCliEntJson.getNumCuenCliente()== null)){
            CuentaClientBD.setNumCuenCliente(CuentCliEntJson.getNumCuenCliente());
        }

        //Numero de tarjeta de cliente Vacio
        if(!(CuentCliEntJson.getTarjetaCliente()== null)){
            CuentaClientBD.setTarjetaCliente(CuentCliEntJson.getTarjetaCliente());
        }

        //Codigo de cliente Vacio
        if(!(CuentCliEntJson.getCodCliente() == null)){
            CuentaClientBD.setCodCliente(CuentCliEntJson.getCodCliente());
        }

        CuentaClienteEntity CuentaCliEntBDActu = cuentaClienteInterface.save(CuentaClientBD);

        return  ResponseEntity.ok(CuentaCliEntBDActu);
    }
}
