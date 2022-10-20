package com.example.proyectoweb_h93.entity;

import javax.persistence.*;

@Entity
@Table(name = "userrol")
public class UsuarioRolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idusuariorol;

    @ManyToOne(fetch = FetchType.EAGER)
    private UsuariosEntity usuariorol;
    @ManyToOne
    private RolEntity rolusario;

    public Integer getIdusuariorol() {
        return idusuariorol;
    }

    public void setIdusuariorol(Integer idusuariorol) {
        this.idusuariorol = idusuariorol;
    }

    public UsuariosEntity getUsuariorol() {
        return usuariorol;
    }

    public void setUsuariorol(UsuariosEntity usuariorol) {
        this.usuariorol = usuariorol;
    }

    public RolEntity getRolusario() {
        return rolusario;
    }

    public void setRolusario(RolEntity rolusario) {
        this.rolusario = rolusario;
    }
}
