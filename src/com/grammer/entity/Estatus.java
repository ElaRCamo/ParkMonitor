package com.grammer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="[dbo].[Estatus]")
public class Estatus {
	@Id
	@Column(name="idEstatus")
	private int idEstatus;
	
	@Column(name="descripcion")
	private String descripcion;

	public int getIdEstatus() {
		return idEstatus;
	}

	public void setIdEstatus(int idEstatus) {
		this.idEstatus = idEstatus;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Estatus [idEstatus=" + idEstatus + ", descripcion=" + descripcion + "]";
	}
}
