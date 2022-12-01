package com.example.proyectoweb_h93.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="categoria")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoriaId;
    private String titulo;
    private String descripcion;

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public Set<ExamenEntity> getExamenEntity() {
        return examenEntity;
    }

    public void setExamenEntity(Set<ExamenEntity> examenEntity) {
        this.examenEntity = examenEntity;
    }

    @OneToMany(mappedBy = "categoria",cascade = CascadeType.ALL)
    private Set<ExamenEntity> examenEntity = new HashSet<>();

}
