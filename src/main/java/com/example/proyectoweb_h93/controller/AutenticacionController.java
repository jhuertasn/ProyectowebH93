package com.example.proyectoweb_h93.controller;

import com.example.proyectoweb_h93.config.JwtUtilies;
import com.example.proyectoweb_h93.entity.UsuariosEntity;
import com.example.proyectoweb_h93.entity.jwtRequest;
import com.example.proyectoweb_h93.entity.jwtResponse;
import com.example.proyectoweb_h93.service.Implement.UserDetailsServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
@RequestMapping("/autenticacion")
@CrossOrigin("*")
public class AutenticacionController {

    //se construlle una variable userDetail para usar todas las funciones de esa clase
    @Autowired
    private UserDetailsServicesImpl userDetail;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtilies jwtUtiles;

    //se agrego la clase Principal y getName en ves de ""
    @GetMapping("/userloggin")
    public UsuariosEntity obtenerUsuario(Principal principal){
        return  (UsuariosEntity) userDetail.loadUserByUsername(principal.getName());
    }

    @PostMapping("/generartoken")
    //recibe cualquier response con el ?
    public ResponseEntity<?> generarToken (@RequestBody jwtRequest jwtR) throws  Exception{
        try{
            // pedimos dos variabloes usuario y clave a jwtR
            this.autenticar(jwtR.getUsername(),jwtR.getPassword());
        }catch(Exception e){
            //se pinta la excepcion que se genera
            e.printStackTrace();
            throw  new Exception("Usuario mal registrado");
        }

        UserDetails userDetails = userDetail.loadUserByUsername(jwtR.getUsername());
        String token = jwtUtiles.generateToken(userDetails);

        return  ResponseEntity.ok(new jwtResponse(token));
    }

    public void autenticar (String username,String password) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException e){
            throw new Exception("Usuario Desabilitado" + e.getMessage());
        }catch (BadCredentialsException be){
            throw new Exception("Credencial Erronea" + be.getMessage());
        }
    }
}
