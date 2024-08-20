package com.grammer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="[dbo].[TipoVehiculo]")
public class TipoVehiculo {
	@Id
	@Column(name="idTipo")
	private int idTipo;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="color")
	private String color;

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "TipoVehiculo [idTipo=" + idTipo + ", descripcion=" + descripcion + ", color=" + color + "]";
	}

}
