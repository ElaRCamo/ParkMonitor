package com.grammer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="[dbo].[Corbatines]")
public class Corbatines {

    @Id
    @Column(name="idCorbatin")
    private int idCorbatin;
    
    @ManyToOne
    @JoinColumn(name="idVehiculo", referencedColumnName="idVehiculo", insertable=false, updatable=false)
    private Vehiculos vehiculo; // Relación con la entidad Vehiculos
    
    @ManyToOne
    @JoinColumn(name="idEstatus", referencedColumnName="idEstatus", insertable=false, updatable=false)
    private Estatus estatus; // Relación con la entidad Estatus

    // Getters y Setters

    public int getIdCorbatin() {
        return idCorbatin;
    }

    public void setIdCorbatin(int idCorbatin) {
        this.idCorbatin = idCorbatin;
    }

    public Vehiculos getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculos vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Estatus getEstatus() {
        return estatus;
    }

    public void setEstatus(Estatus estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Corbatines [idCorbatin=" + idCorbatin + ", vehiculo=" + vehiculo + ", estatus=" + estatus + "]";
    }
}

