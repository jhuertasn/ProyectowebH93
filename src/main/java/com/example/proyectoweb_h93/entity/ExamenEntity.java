package com.example.proyectoweb_h93.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="examenes")
public class ExamenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examenId;

    private String titulo;
    private String descripcion;
    private String puntosmaximos;
    private String numerodepreguntas;
    public boolean activo = false;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private CategoriaEntity categoria;

    @OneToMany(mappedBy = "examen",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<PreguntaEntity> preguntas = new HashSet<>();

    public Long getExamenId() {
        return examenId;
    }

    public void setExamenId(Long examenId) {
        this.examenId = examenId;
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

    public String getPuntosmaximos() {
        return puntosmaximos;
    }

    public void setPuntosmaximos(String puntosmaximos) {
        this.puntosmaximos = puntosmaximos;
    }

    public String getNumerodepreguntas() {
        return numerodepreguntas;
    }

    public void setNumerodepreguntas(String numerodepreguntas) {
        this.numerodepreguntas = numerodepreguntas;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public CategoriaEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEntity categoria) {
        this.categoria = categoria;
    }

    public Set<PreguntaEntity> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Set<PreguntaEntity> preguntas) {
        this.preguntas = preguntas;
    }


    public ExamenEntity(){

    }
}
