package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table(name = "ciudades")
public class Ciudad implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoPostal;
	
	@NotEmpty
	private String nombre;
	

	@JoinColumn(name = "nombre_pais")
	@ManyToOne(cascade = CascadeType.ALL)
	private Pais nombrePais;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(Long codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Pais getNombrePais() {
		return nombrePais;
	}

	public void setNombrePais(Pais nombrePais) {
		this.nombrePais = nombrePais;
	}






}
