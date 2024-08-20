package com.grammer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="Bitacora") // Asegúrate de que este nombre sea correcto en tu base de datos
public class Bitacora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idRegistro")
    private int idRegistro;

    @ManyToOne
    @JoinColumn(name="idCorbatin", referencedColumnName="idCorbatin", nullable=false, updatable=false)
    private Corbatines corbatin; // Relación con la entidad Corbatin

    @Column(name="fechaEntrada")
    private LocalDate fechaEntrada;

    @Column(name="fechaSalida")
    private LocalDate fechaSalida; 

    @Column(name="horaEntrada")
    private LocalTime horaEntrada; 

    @Column(name="horaSalida")
    private LocalTime horaSalida; 

    // Getters y Setters

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Corbatines getCorbatin() {
        return corbatin;
    }

    public void setCorbatin(Corbatines corbatin) {
        this.corbatin = corbatin;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    @Override
    public String toString() {
        return "Bitacora [idRegistro=" + idRegistro + ", corbatin=" + corbatin + ", fechaEntrada=" + fechaEntrada
                + ", fechaSalida=" + fechaSalida + ", horaEntrada=" + horaEntrada + ", horaSalida=" + horaSalida + "]";
    }
}

