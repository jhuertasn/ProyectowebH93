package com.example.proyectoweb_h93.service.Implement;

import com.example.proyectoweb_h93.entity.UsuariosEntity;
import com.example.proyectoweb_h93.entity.UsuarioRolEntity;
import com.example.proyectoweb_h93.repository.RolRepository;
import com.example.proyectoweb_h93.repository.UsuarioRepository;
import com.example.proyectoweb_h93.service.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UsuarioServiceImplement implements UsuarioServices {

    @Autowired
    private UsuarioRepository userRepo;

    @Autowired
    private RolRepository rolRepo;
    // aca se construye la logica que nesesitas para UsuarioServices
    // 3 tipos de objetos uno de mi json otro que creo y uno de mi backend
    public UsuariosEntity guardarUsuarioService(UsuariosEntity usuariosJson, Set<UsuarioRolEntity> usuarioRolController) throws  Exception{
       // se crea la variable userlocal
       UsuariosEntity userlocal= userRepo.findByUsername(usuariosJson.getUsername());
        if (userlocal != null) {
            System.out.println("Usuario ya existe");
        } else {
            for(UsuarioRolEntity usuarioRolEntity :usuarioRolController){
                rolRepo.save(usuarioRolEntity.getRolusario());
                // alli se quedo en la clase del 30 de setiembre
            }
            usuariosJson.getUsuariorolentity().addAll(usuarioRolController);
            userlocal = userRepo.save(usuariosJson);
        }
        return userlocal;
    }

    @Override
    public UsuariosEntity obtenerUsuarioService(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public void eliminarUsuarioService(int idusurios) {

    }


}
