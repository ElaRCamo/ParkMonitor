package com.grammer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="[dbo].[Vehiculos]")
public class Vehiculos {

    @Id
    @Column(name="idVehiculo")
    private int idVehiculo;
    
    @ManyToOne
    @JoinColumn(name="nomina", referencedColumnName="nomina", insertable=false, updatable=false)
    private Usuarios usuario; // Relación con la entidad Usuarios
    
    @ManyToOne
    @JoinColumn(name="idTipo", referencedColumnName="idTipo", insertable=false, updatable=false)
    private TipoVehiculo tipo; // Relación con la entidad TipoVehiculo
    
    @Column(name="placas")
    private String placas;
    
    @Column(name="modelo")
    private String modelo;
    
    @Column(name="color")
    private String color;

    // Getters y Setters

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public TipoVehiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
    }

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Vehiculos [idVehiculo=" + idVehiculo + ", usuario=" + usuario + ", tipo=" + tipo + ", placas=" + placas
                + ", modelo=" + modelo + ", color=" + color + "]";
    }
}

