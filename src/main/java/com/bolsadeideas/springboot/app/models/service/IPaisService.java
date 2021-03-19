package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bolsadeideas.springboot.app.models.entity.Pais;

/**
 * 
 * @author Daniel Cirilo
 *
 */
public interface IPaisService {
	/**
	 * Metodo para buscar todos los paises en la base de datos
	 * @return retorna la lista 
	 */
	public List<Pais> findAll();
	
	/**
	 * Metodo que guarda el pais creado
	 * @param pais
	 */
	public void save(Pais pais);
	
	
	/**
	 * Metodo que busca un pais por el nombre 
	 * @param nombre
	 * @return retorna el pais
	 */
	public Pais findOne(String nombre);
	
	/**
	 * Metodo encargado de  cambiar de pagina y mostrar mas paises
	 * @param pageable
	 * @return retorna la pagina seleccionada 
	 */
	Page<Pais> getAll(Pageable pageable);
	
}
