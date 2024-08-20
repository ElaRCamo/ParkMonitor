package com.grammer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name="[dbo].[Modelos]")
public class Modelos {
	
	@Id
	@Column(name="IdModelo")
	private String idModelo;
	
	@Column(name="NombreModelo")
	private String nombreModelo;
	
	@Column(name="TipoModelo")
	private String tipoModelo;

	public String getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(String idModelo) {
		this.idModelo = idModelo;
	}

	public String getNombreModelo() {
		return nombreModelo;
	}

	public void setNombreModelo(String nombreModelo) {
		this.nombreModelo = nombreModelo;
	}

	public String getTipoModelo() {
		return tipoModelo;
	}

	public void setTipoModelo(String tipoModelo) {
		this.tipoModelo = tipoModelo;
	}

	@Override
	public String toString() {
		return "Modelos [idModelo=" + idModelo + ", nombreModelo=" + nombreModelo + ", tipoModelo=" + tipoModelo + "]";
	}

	
}
