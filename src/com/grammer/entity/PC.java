package com.grammer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Id;


@Entity
@Table(name="[dbo].[PC]")
public class PC {
	
	@Id
	@Column(name="IdPc")
	private String idPc;
	
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
	
	@Column(name="HP")
	private String hp;
	
	@Column(name="Observaciones")
	private String observaciones;

	public String getIdPc() {
		return idPc;
	}

	public void setIdPc(String idPc) {
		this.idPc = idPc;
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

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public String toString() {
		return "PC [idPc=" + idPc + ", cantidad=" + cantidad + ", usuario=" + usuario + ", area=" + area + ", lugar="
				+ lugar + ", nombreEquipo=" + nombreEquipo + ", noSerie=" + noSerie + ", modelo=" + modelo + ", hp="
				+ hp + ", observaciones=" + observaciones + "]";
	}

	
}
