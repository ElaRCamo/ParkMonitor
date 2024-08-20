package com.grammer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name="[dbo].[Areas]")
public class Areas {
	
	@Id
	@Column(name="IdArea")
	private String idArea;
	
	@Column(name="NombreArea")
	private String nombreArea;

	public String getIdArea() {
		return idArea;
	}

	public void setIdArea(String idArea) {
		this.idArea = idArea;
	}

	public String getNombreArea() {
		return nombreArea;
	}

	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}

	@Override
	public String toString() {
		return "Areas [idArea=" + idArea + ", nombreArea=" + nombreArea + "]";
	}
	
	
}
