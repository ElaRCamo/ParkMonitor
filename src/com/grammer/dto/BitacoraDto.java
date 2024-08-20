package com.grammer.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class BitacoraDto {
	private int idRegistro;
	private int idCorbatin;
    private String estatusDescripcion;
    private String usuarioNomina;
    private String usuarioNombre;
    private String telefono;
    private String tipoDescripcion;
    private String vehiculoPlacas;
    private String vehiculoModelo;
    private String vehiculoColor;
    private LocalDate fechaEntrada; 
    private LocalTime horaEntrada;  
    private LocalDate fechaSalida;  
    private LocalTime horaSalida;   

    // Constructor
    public BitacoraDto(int idRegistro,int idCorbatin, String estatusDescripcion, String usuarioNomina, String usuarioNombre,
                       String telefono, String tipoDescripcion, String vehiculoPlacas, String vehiculoModelo,
                       String vehiculoColor, LocalDate fechaEntrada, LocalTime horaEntrada, LocalDate fechaSalida,
                       LocalTime horaSalida) {
    	this.idRegistro = idRegistro;
    	this.idCorbatin = idCorbatin;
        this.estatusDescripcion = estatusDescripcion;
        this.usuarioNomina = usuarioNomina;
        this.usuarioNombre = usuarioNombre;
        this.telefono = telefono;
        this.tipoDescripcion = tipoDescripcion;
        this.vehiculoPlacas = vehiculoPlacas;
        this.vehiculoModelo = vehiculoModelo;
        this.vehiculoColor = vehiculoColor;
        this.fechaEntrada = fechaEntrada;
        this.horaEntrada = horaEntrada;
        this.fechaSalida = fechaSalida;
        this.horaSalida = horaSalida;
    }

    // Getters y Setters

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }
    
    public int getIdCorbatin() {
        return idCorbatin;
    }

    public void setIdCorbatin(int idCorbatin) {
        this.idCorbatin = idCorbatin;
    }

    public String getEstatusDescripcion() {
        return estatusDescripcion;
    }

    public void setEstatusDescripcion(String estatusDescripcion) {
        this.estatusDescripcion = estatusDescripcion;
    }

    public String getUsuarioNomina() {
        return usuarioNomina;
    }

    public void setUsuarioNomina(String usuarioNomina) {
        this.usuarioNomina = usuarioNomina;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoDescripcion() {
        return tipoDescripcion;
    }

    public void setTipoDescripcion(String tipoDescripcion) {
        this.tipoDescripcion = tipoDescripcion;
    }

    public String getVehiculoPlacas() {
        return vehiculoPlacas;
    }

    public void setVehiculoPlacas(String vehiculoPlacas) {
        this.vehiculoPlacas = vehiculoPlacas;
    }

    public String getVehiculoModelo() {
        return vehiculoModelo;
    }

    public void setVehiculoModelo(String vehiculoModelo) {
        this.vehiculoModelo = vehiculoModelo;
    }

    public String getVehiculoColor() {
        return vehiculoColor;
    }

    public void setVehiculoColor(String vehiculoColor) {
        this.vehiculoColor = vehiculoColor;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    @Override
    public String toString() {
        return "BitacoraDto [idCorbatin=" + idCorbatin + ", estatusDescripcion=" + estatusDescripcion +
               ", usuarioNomina=" + usuarioNomina + ", usuarioNombre=" + usuarioNombre + ", telefono=" + telefono +
               ", tipoDescripcion=" + tipoDescripcion + ", vehiculoPlacas=" + vehiculoPlacas +
               ", vehiculoModelo=" + vehiculoModelo + ", vehiculoColor=" + vehiculoColor +
               ", fechaEntrada=" + fechaEntrada + ", horaEntrada=" + horaEntrada +
               ", fechaSalida=" + fechaSalida + ", horaSalida=" + horaSalida + "]";
    }
}

