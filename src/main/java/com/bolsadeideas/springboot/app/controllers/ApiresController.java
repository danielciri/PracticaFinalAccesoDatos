package com.bolsadeideas.springboot.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.app.models.entity.AgenciaVentaCoche;
import com.bolsadeideas.springboot.app.models.entity.Anuncio;
import com.bolsadeideas.springboot.app.models.entity.Ciudad;
import com.bolsadeideas.springboot.app.models.entity.Pais;
import com.bolsadeideas.springboot.app.models.entity.Vehiculo;
import com.bolsadeideas.springboot.app.models.service.IAgenciaVentaCocheService;
import com.bolsadeideas.springboot.app.models.service.IAnuncioService;
import com.bolsadeideas.springboot.app.models.service.ICiudadService;
import com.bolsadeideas.springboot.app.models.service.IPaisService;
import com.bolsadeideas.springboot.app.models.service.IVehiculoService;



@RestController
@RequestMapping("/api")
public class ApiresController {

	
	@Autowired
	private IVehiculoService vehiculoService;
	
	@Autowired
	private IPaisService paisService;
	
	@Autowired
	private ICiudadService ciudadService;
	
	@Autowired
	private IAgenciaVentaCocheService agenciaService;
	
	@Autowired
	private IAnuncioService anuncioService;

	
	/**
	 * Este metodo lo implementados para cargar los datos de nuestros 
	 * datos almacenados en la base de datos 
	 * @return retornamos todos los datos 
	 */
	@GetMapping("/listVehiculo")
	public List<Vehiculo> list() {
		return vehiculoService.findAll();
	}
	/**
	 * Este metodo lo implementados para cargar los datos de nuestros 
	 * datos almacenados en la base de datos 
	 * @return retornamos todos los datos 
	 */
	@GetMapping("/listPais")
	public List<Pais> listaPais() {
		return 	paisService.findAll();
	}
	/**
	 * Este metodo lo implementados para cargar los datos de nuestros 
	 * datos almacenados en la base de datos 
	 * @return retornamos todos los datos 
	 */
	@GetMapping("/listCiudad")
	public List<Ciudad> listaCiudad() {
		return 	ciudadService.findAll();
	}
	/**
	 * Este metodo lo implementados para cargar los datos de nuestros 
	 * datos almacenados en la base de datos 
	 * @return retornamos todos los datos 
	 */
	@GetMapping("/listAgencia")
	public List<AgenciaVentaCoche> listaAgencia() {
		return 	agenciaService.findAll();
	}
	/**
	 * Este metodo lo implementados para cargar los datos de nuestros 
	 * datos almacenados en la base de datos 
	 * @return retornamos todos los datos 
	 */
	@GetMapping("/listAnuncio")
	public List<Anuncio> listsAnuncio() {
		return 		anuncioService.findAll();
	}






	
	
	

}
