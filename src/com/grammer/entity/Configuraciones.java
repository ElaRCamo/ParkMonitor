package com.grammer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name="[dbo].[Configuraciones]")
public class Configuraciones {
	
	@Id
	@Column(name="IdConfiguracion")
	private String idConfiguracion;
	
	@Column(name="Cuenta")
	private String cuenta;

	@Column(name="Impresora")
	private String impresora;

	public String getIdConfiguracion() {
		return idConfiguracion;
	}

	public void setIdConfiguracion(String idConfiguracion) {
		this.idConfiguracion = idConfiguracion;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getImpresora() {
		return impresora;
	}

	public void setImpresora(String impresora) {
		this.impresora = impresora;
	}

	@Override
	public String toString() {
		return "Configuraciones [idConfiguracion=" + idConfiguracion + ", cuenta=" + cuenta + ", impresora=" + impresora
				+ "]";
	}
	
	
	
}
