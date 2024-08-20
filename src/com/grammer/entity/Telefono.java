package com.grammer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name="[dbo].[Telefonos]")
public class Telefono {
	
	@Id
	@Column(name="IdTelefono")
	private String idTelefono;
	
	@Column(name="Usuario")
	private String usuario;
	
	@Column(name="Area")
	private String area;
	
	@Column(name="Numero")
	private String numero;
	
	@Column(name="Modelo")
	private String modelo;

	@Column(name="IME")
	private String ime;

	@Column(name="Estatus")
	private int estatus;
	
	@Column(name="Observaciones")
	private String observaciones;

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getIdTelefono() {
		return idTelefono;
	}

	public void setIdTelefono(String idTelefono) {
		this.idTelefono = idTelefono;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "Telefono [idTelefono=" + idTelefono + ", usuario=" + usuario + ", area=" + area + ", numero=" + numero
				+ ", modelo=" + modelo + ", ime=" + ime + ", estatus=" + estatus + "]";
	}

	
}
