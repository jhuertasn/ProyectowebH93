package com.example.proyectoweb_h93.controller;

import com.example.proyectoweb_h93.entity.RolEntity;
import com.example.proyectoweb_h93.entity.UsuariosEntity;
import com.example.proyectoweb_h93.entity.UsuarioRolEntity;
import com.example.proyectoweb_h93.service.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/usuario")
@CrossOrigin ("*")
//@CrossOrigin ("http://localhost:4200/")
public class UsuarioController {

    @Autowired
    private UsuarioServices userService;

    @GetMapping (value = "/{username}")
    public UsuariosEntity obtenerUsuario (@PathVariable("username") String username) {
        UsuariosEntity userlocal = new UsuariosEntity();
        userlocal = userService.obtenerUsuarioService(username);
        return userlocal;
    }
    @PostMapping("/registrarUsuario")
    public UsuariosEntity agregarUsuario (@RequestBody UsuariosEntity userJsonEntity) throws Exception{

        Set<UsuarioRolEntity> userRolController =  new HashSet<>();

        RolEntity rol = new RolEntity();
        //seleccionamos id rol y nombre rol de rolEntity
        rol.setIdRol(1);
        rol.setNombrol("Cliente");

        UsuarioRolEntity userrol = new UsuarioRolEntity();
        userrol.setUsuariorol(userJsonEntity);
        userrol.setRolusario(rol);

        userRolController.add(userrol);

        UsuariosEntity response = userService.guardarUsuarioService(userJsonEntity,userRolController);
        return response ;
    }
}
