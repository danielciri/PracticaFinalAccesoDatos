package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Set;

@Entity
public class Anuncio implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoAnuncio;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codigo_agencia")
	private AgenciaVentaCoche codigoAgencia;


	@NotNull
	@Column(name = "fecha_publicacion")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaPublicacion;

	@NotNull
	private float precio;

	@NotNull
	@Column(name = "num_km")
	private float numKm;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "numero_oferta_vehiculo")
	private Vehiculo nuVehiculo;




	


	public Long getCodigoAnuncio() {
		return codigoAnuncio;
	}

	public void setCodigoAnuncio(Long codigoAnuncio) {
		this.codigoAnuncio = codigoAnuncio;
	}

	public AgenciaVentaCoche getCodigoAgencia() {
		return codigoAgencia;
	}

	public void setCodigoAgencia(AgenciaVentaCoche codigoAgencia) {
		this.codigoAgencia = codigoAgencia;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getNumKm() {
		return numKm;
	}

	public void setNumKm(float numKm) {
		this.numKm = numKm;
	}

	public Vehiculo getNuVehiculo() {
		return nuVehiculo;
	}

	public void setNuVehiculo(Vehiculo nuVehiculo) {
		this.nuVehiculo = nuVehiculo;
	}
	
	
	
	
}
