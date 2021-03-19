package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bolsadeideas.springboot.app.models.entity.Anuncio;
import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.entity.Vehiculo;

public interface IVehiculoService {
	
	/**
	 * Metodo para buscar todos los vehiculos en la base de datos
	 * @return retorna la lista 
	 */
	public List<Vehiculo> findAll();

	/**
	 * Metodo que guarda el vehiculo creado
	 * @param vehiculo
	 */
	public void save(Vehiculo vehiculo);
	
	/**
	 * Metodo que busca un vehiculo por el id 
	 * @param id
	 * @return retorna el vehiculo
	 */
	public Vehiculo findOne(Long id);
	
	/**
	 * Metodo que se encarga de eliminar un vehiculo
	 * @param idVehiculo busca el vehiculo a eliminar por el id
	 */
	public void delete(Long idVehiculo);
	
	/**
	 * Metodo encargado de  cambiar de pagina y mostrar mas vehiculos
	 * @param pageable
	 * @return retorna la pagina seleccionada 
	 */
	Page<Vehiculo> getAll(Pageable pageable);
	
}
