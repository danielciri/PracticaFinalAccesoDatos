package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bolsadeideas.springboot.app.models.entity.AgenciaVentaCoche;
import com.bolsadeideas.springboot.app.models.entity.Cliente;

public interface IAgenciaVentaCocheService {
	
	/**
	 * Metodo implementado para mostrar la lista de agencias
	 * @return nos retorna la lista
	 */
	public List<AgenciaVentaCoche> findAll();
	/**
	 * Metodo implementado para aguardar las agencias 
	 * @param agenciaVentaCoche
	 */
	public void save(AgenciaVentaCoche agenciaVentaCoche);
	
	/**
	 * Metodo encargado de  cambiar de pagina y mostrar mas agencia
	 * @param pageable
	 * @return retorna la pagina seleccionada 
	 */
	Page<AgenciaVentaCoche> getAll(Pageable pageable);
}
