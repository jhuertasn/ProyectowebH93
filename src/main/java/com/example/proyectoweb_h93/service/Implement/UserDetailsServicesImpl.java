package com.example.proyectoweb_h93.service.Implement;

import com.example.proyectoweb_h93.entity.UsuariosEntity;
import com.example.proyectoweb_h93.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// se tienen que importar los metodos
@Service
public class UserDetailsServicesImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository userepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // traer los datos del usuario logeado en el objeto entidad userload
       UsuariosEntity userload = userepo.findByUsername(username);
       // si no encuentra el usuario
        if(userload==null){
            throw new UsernameNotFoundException("Usuario no Encontrado");
        }
        return userload;
    }
}
