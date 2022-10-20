package com.example.proyectoweb_h93.entity;

import javax.persistence.*;

@Entity
@Table (name ="cuentacliente")

//@Table (name ="cuentacliente" ,catalog = "marketplace", schema = "")
public class CuentaClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "codcuentacliente")
    private Integer CodCuentaCliente;
    @Column (name = "numcuencliente")
    private Integer NumCuenCliente;
    @Column (name = "tarjetacliente")
    private Integer TarjetaCliente;
    @Column (name = "codcliente")
    private Integer CodCliente;

    public Integer getCodCuentaCliente() {
        return CodCuentaCliente;
    }

    public void setCodCuentaCliente(Integer codCuentaCliente) {
        CodCuentaCliente = codCuentaCliente;
    }

    public Integer getNumCuenCliente() {
        return NumCuenCliente;
    }

    public void setNumCuenCliente(Integer numCuenCliente) {
        NumCuenCliente = numCuenCliente;
    }

    public Integer getTarjetaCliente() {
        return TarjetaCliente;
    }

    public void setTarjetaCliente(Integer tarjetaCliente) {
        TarjetaCliente = tarjetaCliente;
    }

    public Integer getCodCliente() {
        return CodCliente;
    }

    public void setCodCliente(Integer codCliente) {
        CodCliente = codCliente;
    }
}
