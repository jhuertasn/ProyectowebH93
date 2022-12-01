package com.example.proyectoweb_h93.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name ="pregunta")
public class PreguntaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer preguntaid;
    private String contenido;

    public Integer getPreguntaid() {
        return preguntaid;
    }

    public void setPreguntaid(Integer preguntaid) {
        this.preguntaid = preguntaid;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(String opcion3) {
        this.opcion3 = opcion3;
    }

    public String getOpcion4() {
        return opcion4;
    }

    public void setOpcion4(String opcion4) {
        this.opcion4 = opcion4;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public ExamenEntity getExamen() {
        return examen;
    }

    public void setExamen(ExamenEntity examen) {
        this.examen = examen;
    }

    private String opcion1;
    private String opcion2;
    private String opcion3;
    private String opcion4;
    private String imagen;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private ExamenEntity examen;
}
