package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.lowagie.text.pdf.PdfPCell;

@Entity
@Table(name = "vehiculo")
public class Vehiculo implements Serializable {
	
	
	@Id
	@Column(name = "numero_oferta")
	@GeneratedValue(strategy =GenerationType.IDENTITY  )
	private Long numeroOferta;
	
	public Long getNumeroOferta() {
		return numeroOferta;
	}


	public void setNumeroOferta(Long numeroOferta) {
		this.numeroOferta = numeroOferta;
	}


	@NotEmpty
	private String marca;
	
	@NotEmpty
	private String modelo;
	
	@NotNull
	@Column(name = "num_plazas")
	private int numPlazas;
		
	@NotEmpty
	@Column(name = "tipo_cambio")
	private String tipoCambio;
	
	private String foto;
	


	@NotNull
	@Column(name = "anyo_vehiculo")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date anyo_vehiculo;
	
	@NotEmpty
	private String combustible;
	
	@NotEmpty
	private String tipo;

	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_agencia")
	private AgenciaVentaCoche codAgencia;





	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public int getNumPlazas() {
		return numPlazas;
	}


	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}


	public String getTipoCambio() {
		return tipoCambio;
	}


	public void setTipoCambio(String tipoCambio) {
		this.tipoCambio = tipoCambio;
	}



	public void setAnyo_vehiculo(Date anyo_vehiculo) {
		this.anyo_vehiculo = anyo_vehiculo;
	}
	


	public Date getAnyo_vehiculo() {
		return anyo_vehiculo;
	}


	public String getCombustible() {
		return combustible;
	}


	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public AgenciaVentaCoche getCodAgencia() {
		return codAgencia;
	}


	public void setCodAgencia(AgenciaVentaCoche codAgencia) {
		this.codAgencia = codAgencia;
	}




	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}

	
	
	
}
