package com.example.proyectoweb_h93.entity;



import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="rol")
public class RolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;
    private String nombrol;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "rolusario")
    private Set<UsuarioRolEntity> rolusuarioentity = new HashSet<>();

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombrol() {
        return nombrol;
    }

    public void setNombrol(String nombrol) {
        this.nombrol = nombrol;
    }

    public Set<UsuarioRolEntity> getRolusuarioentity() {
        return rolusuarioentity;
    }

    public void setRolusuarioentity(Set<UsuarioRolEntity> rolusuarioentity) {
        this.rolusuarioentity = rolusuarioentity;
    }

    public RolEntity(){

    }
}
