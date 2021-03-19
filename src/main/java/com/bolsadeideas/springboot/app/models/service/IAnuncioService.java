package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bolsadeideas.springboot.app.models.entity.Anuncio;

public interface IAnuncioService {
	
	/**
	 * Metodo para buscar todos los anuncios en la base de datos
	 * @return retorna la lista 
	 */
	public List<Anuncio> findAll();


	/**
	 * Metodo que guarda el anuncio creado
	 * @param anuncio
	 */
	public void save(Anuncio Anuncio);
	
	/**
	 * Metodo que busca un anuncio por el id 
	 * @param id
	 * @return retorna el anuncio
	 */
	public Anuncio findOne(Long id);
	
	
	/**
	 * Metodo que se encarga de eliminar un anuncio
	 * @param idAnuncio busca el anuncio a eliminar por el id
	 */
	public void delete(Long idAnuncio);
	
	/**
	 * Metodo encargado de  cambiar de pagina y mostrar mas anuncios
	 * @param pageable
	 * @return retorna la pagina seleccionada 
	 */
	Page<Anuncio> getAll(Pageable pageable);
	
}
