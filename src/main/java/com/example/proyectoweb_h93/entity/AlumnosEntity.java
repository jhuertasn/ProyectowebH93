package com.example.proyectoweb_h93.entity;

import javax.persistence.*;

@Entity
@Table(name ="alumnos")
public class AlumnosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idalumno")
    private Integer IdAlumno;
    @Column (name = "nombalumno")
    private Integer NomBalumno;
    @Column (name = "apelalumno")
    private Integer ApeLalumno;
    @Column (name = "correo")
    private Integer CoRreo;
    @Column (name = "edad")
    private Integer EdaD;
    @Column (name = "iporigen")
    private Integer IporIgen;
}
