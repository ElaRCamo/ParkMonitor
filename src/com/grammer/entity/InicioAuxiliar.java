package com.grammer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="[dbo].[INICIO_AUXILIAR]")
public class InicioAuxiliar {

	@Id
	@Column(name="IdAux")
	private int idAux;
	
	@Column(name="NomAux")
	private String nomAux;

	public int getIdAux() {
		return idAux;
	}

	public void setIdAux(int idAux) {
		this.idAux = idAux;
	}

	public String getNomAux() {
		return nomAux;
	}

	public void setNomAux(String nomAux) {
		this.nomAux = nomAux;
	}

	@Override
	public String toString() {
		return "InicioAuxiliar [idAux=" + idAux + ", nomAux=" + nomAux + "]";
	}
}
