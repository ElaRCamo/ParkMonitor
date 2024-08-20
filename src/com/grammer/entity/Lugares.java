package com.grammer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name="[dbo].[Lugares]")
public class Lugares {
	
	@Id
	@Column(name="IdLugar")
	private String idLugar;
	
	@Column(name="NombreLugar")
	private String nombreLugar;

	public String getIdLugar() {
		return idLugar;
	}

	public void setIdLugar(String idLugar) {
		this.idLugar = idLugar;
	}

	public String getNombreLugar() {
		return nombreLugar;
	}

	public void setNombreLugar(String nombreLugar) {
		this.nombreLugar = nombreLugar;
	}

	@Override
	public String toString() {
		return "Lugares [idLugar=" + idLugar + ", nombreLugar=" + nombreLugar + "]";
	}
	
	
}
