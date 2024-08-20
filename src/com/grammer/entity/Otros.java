package com.grammer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name="[dbo].[Otros]")
public class Otros {
	
	@Id
	@Column(name="IdOtros")
	private String idOtros;
	
	@Column(name="Usuario")
	private String usuario;
	
	@Column(name="Area")
	private String area;
	
	@Column(name="NombreEquipo")
	private String nombreEquipo;

	@Column(name="Descripcion")
	private String descripcion;

	@Column(name="Cantidad")
	private int cantidad;

	@Column(name="Estatus")
	private int estatus;

	public String getIdOtros() {
		return idOtros;
	}

	public void setIdOtros(String idOtros) {
		this.idOtros = idOtros;
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

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "Otros [idOtros=" + idOtros + ", usuario=" + usuario + ", area=" + area + ", nombreEquipo="
				+ nombreEquipo + ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", estatus=" + estatus
				+ "]";
	}

	
}
