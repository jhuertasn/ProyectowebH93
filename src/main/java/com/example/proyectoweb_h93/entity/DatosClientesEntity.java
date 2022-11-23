package com.example.proyectoweb_h93.entity;


import javax.persistence.*;

@Entity
//Sql Server
@Table (name ="datosclientes")
//Mysql
//@Table (name ="datosclientes" ,catalog = "marketplace", schema = "")
public class DatosClientesEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "codcliente")
    private Integer CodCliente;
    @Column (name = "nombcliente")
    private String NombCliente;
    @Column (name = "apellcliente")
    private String ApellCliente;
    @Column (name = "dnicliente")
    private String DniCliente;
    @Column (name = "correocliente")
    private String CorreoCliente;

    public Integer getCodCliente() {
        return CodCliente;
    }

    public void setCodCliente(Integer codCliente) {
        CodCliente = codCliente;
    }

    public String getNombCliente() {
        return NombCliente;
    }

    public void setNombCliente(String nombCliente) {
        NombCliente = nombCliente;
    }

    public String getApellCliente() {
        return ApellCliente;
    }

    public void setApellCliente(String apellCliente) {
        ApellCliente = apellCliente;
    }

    public String getDniCliente() {
        return DniCliente;
    }

    public void setDniCliente(String dniCliente) {
        DniCliente = dniCliente;
    }

    public String getCorreoCliente() {
        return CorreoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        CorreoCliente = correoCliente;
    }
}
