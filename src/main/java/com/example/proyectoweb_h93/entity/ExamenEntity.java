package com.example.proyectoweb_h93.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="examen")
public class ExamenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer examenid;

    public Integer getExamenid() {
        return examenid;
    }

    public void setExamenid(Integer examenid) {
        this.examenid = examenid;
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

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public CategoriaEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEntity categoria) {
        this.categoria = categoria;
    }


    private String titulo;
    private String descripcion;
    private String puntosmaximos;
    private String numerodepreguntas;
    public boolean enable = false;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private CategoriaEntity categoria;

    public Set<PreguntaEntity> getPreguntaentity() {
        return preguntaentity;
    }

    public void setPreguntaentity(Set<PreguntaEntity> preguntaentity) {
        this.preguntaentity = preguntaentity;
    }

    @OneToMany(mappedBy = "examen",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<PreguntaEntity> preguntaentity = new HashSet<>();


    public ExamenEntity(){

    }
}
