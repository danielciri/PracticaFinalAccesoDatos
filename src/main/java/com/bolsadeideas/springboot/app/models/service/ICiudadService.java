package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bolsadeideas.springboot.app.models.entity.Anuncio;
import com.bolsadeideas.springboot.app.models.entity.Ciudad;
import com.bolsadeideas.springboot.app.models.entity.Cliente;

public interface ICiudadService {
	
	/**
	 * Metodo para buscar todos las ciudades en la base de datos
	 * @return retorna la lista 
	 */
	public List<Ciudad> findAll();

	/**
	 * Metodo que guarda la ciudad creada
	 * @param pais
	 */
	public void save(Ciudad ciudad);
	

	/**
	 * Metodo que busca la ciudad por el id 
	 * @param id
	 * @return retorna la ciudad
	 */
	public Ciudad findOne(Long id);
	
	/**
	 * Metodo que se encarga de eliminar una ciudad
	 * @param idCiudad busca la ciudad a eliminar por el id
	 */
	public void delete(Long idCiudad);

	/**
	 * Metodo encargado de  cambiar de pagina y mostrar mas ciudades
	 * @param pageable
	 * @return retorna la pagina seleccionada 
	 */
	Page<Ciudad> getAll(Pageable pageable);
	
}
