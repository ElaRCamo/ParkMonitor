package com.grammer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name="[dbo].[Laptop]")
public class Laptop {
	
	@Id
	@Column(name="IdLaptop")
	private String idLaptop;
	
	@Column(name="Cantidad")
	private int cantidad;
	
	@Column(name="Usuario")
	private String usuario;
	
	@Column(name="Area")
	private String area;
	
	@Column(name="Lugar")
	private String lugar;
	
	@Column(name="NombreEquipo")
	private String nombreEquipo;

	@Column(name="NoSerie")
	private String noSerie;

	@Column(name="Modelo")
	private String modelo;
	
	@Column(name="Marca")
	private String marca;
	
	@Column(name="Equipo")
	private String equipo;
	
	@Column(name="Estatus")
	private int estatus;
	
	@Column(name="Observaciones")
	private String observaciones;

	public String getIdLaptop() {
		return idLaptop;
	}

	public void setIdLaptop(String idLaptop) {
		this.idLaptop = idLaptop;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public String getNoSerie() {
		return noSerie;
	}

	public void setNoSerie(String noSerie) {
		this.noSerie = noSerie;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "Laptop [idLaptop=" + idLaptop + ", cantidad=" + cantidad + ", usuario=" + usuario + ", area=" + area
				+ ", lugar=" + lugar + ", nombreEquipo=" + nombreEquipo + ", noSerie=" + noSerie + ", modelo=" + modelo
				+ ", marca=" + marca + ", equipo=" + equipo + ", estatus=" + estatus + ", observaciones="
				+ observaciones + "]";
	}

	
	
}
