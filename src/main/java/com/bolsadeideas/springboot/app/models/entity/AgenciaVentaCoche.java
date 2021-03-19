package com.bolsadeideas.springboot.app.models.entity;

import javax.persistence.CascadeType;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "agencia_venta_coche")
public class AgenciaVentaCoche {
	
	@JoinColumn(name = "ciudad_cod_postal")
	@ManyToOne(cascade = CascadeType.ALL)
	private Ciudad codPostal;
	
	@Id 
	@GeneratedValue(strategy =GenerationType.IDENTITY  )
	private Long codigo;

	@NotEmpty
	private String nombre;

	private Long numeTelefono;
	
	@NotEmpty
	@Email
	private String email;






	public Ciudad getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(Ciudad codPostal) {
		this.codPostal = codPostal;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getNumeTelefono() {
		return numeTelefono;
	}

	public void setNumeTelefono(Long numeTelefono) {
		this.numeTelefono = numeTelefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
