package com.example.proyectoweb_h93.entity;

//import net.minidev.json.annotate.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="usuario")
public class UsuariosEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idusurios;
    private String username;
    private String password;
    private String nombuser;
    private String apelliuser;
    private String emailuser;
    private String telefuser;
    private String perfiluser;
    //valor boleano en IntelliJ
    public boolean enable = true;

    /*public UsuariosEntity(Integer idusurios, String username, String password, String nombuser, String apelliuser, String emailuser, String telefuser, String perfiluser, boolean enable) {
        this.idusurios = idusurios;
        this.username = username;
        this.password = password;
        this.nombuser = nombuser;
        this.apelliuser = apelliuser;
        this.emailuser = emailuser;
        this.telefuser = telefuser;
        this.perfiluser = perfiluser;
        this.enable = enable;
    }*/


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "usuariorol")
    @JsonIgnore
    private Set<UsuarioRolEntity> usuariorolentity = new HashSet<>();

    public Integer getIdusurios() {
        return idusurios;
    }

    public void setIdusurios(Integer idusurios) {
        this.idusurios = idusurios;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombuser() {
        return nombuser;
    }

    public void setNombuser(String nombuser) {
        this.nombuser = nombuser;
    }

    public String getApelliuser() {
        return apelliuser;
    }

    public void setApelliuser(String apelliuser) {
        this.apelliuser = apelliuser;
    }

    public String getEmailuser() {
        return emailuser;
    }

    public void setEmailuser(String emailuser) {
        this.emailuser = emailuser;
    }

    public String getTelefuser() {
        return telefuser;
    }

    public void setTelefuser(String telefuser) {
        this.telefuser = telefuser;
    }

    public String getPerfiluser() {
        return perfiluser;
    }

    public void setPerfiluser(String perfiluser) {
        this.perfiluser = perfiluser;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Set<UsuarioRolEntity> getUsuariorolentity() {
        return usuariorolentity;
    }

    public void setUsuariorolentity(Set<UsuarioRolEntity> usuariorolentity) {
        this.usuariorolentity = usuariorolentity;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    //aqui se trabaja la variable autorizacion
    // se genera el codigo de autorizacion que se manda a autority
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authority> autorizacion = new HashSet<>();
        //recorer a los usuarios
        this.usuariorolentity.forEach(usuarioRolEntity -> {
            autorizacion.add(new Authority(usuarioRolEntity.getRolusario().getNombrol()));
        });
        return autorizacion;
    }
    public UsuariosEntity(){

    }
}