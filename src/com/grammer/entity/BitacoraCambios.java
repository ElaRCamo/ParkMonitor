package com.grammer.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name="[dbo].[BitacoraCambios]")
public class BitacoraCambios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCambio")
	private String idBitacoraCambio;
	
	@Column(name="Cuenta")
	private String cuenta;
	
	@Column(name="tipoCambio")
	private String tipoCambio;
	
	@Column(name="antes")
	private String antes;
	
	@Column(name="despues")
	private String despues;
	
	@Column(name="fechaCambio")
	private Date fechaCambio;

	public String getIdBitacoraCambio() {
		return idBitacoraCambio;
	}

	public void setIdBitacoraCambio(String idBitacoraCambio) {
		this.idBitacoraCambio = idBitacoraCambio;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(String tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	public String getAntes() {
		return antes;
	}

	public void setAntes(String antes) {
		this.antes = antes;
	}

	public String getDespues() {
		return despues;
	}

	public void setDespues(String despues) {
		this.despues = despues;
	}

	public Date getFechaCambio() {
		return fechaCambio;
	}

	public void setFechaCambio(Date fechaCambio) {
		this.fechaCambio = fechaCambio;
	}

	@Override
	public String toString() {
		return "BitacoraCambios [idBitacoraCambio=" + idBitacoraCambio + ", cuenta=" + cuenta + ", tipoCambio="
				+ tipoCambio + ", antes=" + antes + ", despues=" + despues + ", fechaCambio=" + fechaCambio + "]";
	}

	
}
