package com.grammer.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="[dbo].[Usuarios]")
public class Usuarios {
    
    @Id
    @Column(name="nomina")
    private String nomina;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="contrasenia")
    private String password;
    
    @Column(name="telefono")
    private String telefono;
    
    @ManyToOne
    @JoinColumn(name="idRol", referencedColumnName="idRol", insertable=false, updatable=false)
    private Roles rol; // Relación con la entidad Roles
    
    
    // Getters y Setters

    public String getNomina() {
        return nomina;
    }

    public void setNomina(String nomina) {
        this.nomina = nomina;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Roles getRol() {
		return rol;
	}

	public void setRol(Roles rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuarios [nomina=" + nomina + ", nombre=" + nombre + ", password=" + password + ", telefono=" + telefono
				+ ", rol=" + rol + "]";
	}

	
}

