package com.bolsadeideas.springboot.app.controllers;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.bolsadeideas.springboot.app.models.entity.AgenciaVentaCoche;
import com.bolsadeideas.springboot.app.models.service.IAgenciaVentaCocheService;
import com.bolsadeideas.springboot.app.models.service.ICiudadService;


@Controller
@SessionAttributes("agencia")
public class AgenciaVentaCocheController {

	@Autowired
	private IAgenciaVentaCocheService agenciaService;
	@Autowired
	private ICiudadService ciudadService;
	
	@Autowired
	private MessageSource messageSource;


	/**
	 * Metod implementado para realizar el paginador
	 * @param params recibimos los parametros
	 * @param model pasamos el modelo para pintar la vista
	 * @param locale pasamos el locale para saber el idioma
	 * @return
	 */
	@GetMapping(value = "/listarAgencias")
	public String listar(@RequestParam Map<String, Object> params,Model model, Locale locale) {
		model.addAttribute("titulo", messageSource.getMessage("text.agencia.listar.titulo", null, locale));
		model.addAttribute("agencias", agenciaService.findAll());
	int page = params.get("page") != null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0;
		
		PageRequest pageRequest = PageRequest.of(page, 2);
		
		Page<AgenciaVentaCoche> pagePersona = agenciaService.getAll(pageRequest);
		
		int totalPage = pagePersona.getTotalPages();
		if(totalPage > 0) {
			List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
			model.addAttribute("pages", pages);
		}
		
		
		model.addAttribute("list", pagePersona.getContent());
		model.addAttribute("current", page + 1);
		model.addAttribute("next", page + 2);
		model.addAttribute("prev", page);
		model.addAttribute("last", totalPage);

		
		return "listarAgenciaVentaCoche";
	}
	
	/**
	 * Metodo implementado para crear nuevas agencias
	 * @param model le pasamos el model para pasar datos a la vista
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/formAgencias")
	public String crear(Model model) {

		AgenciaVentaCoche cliente = new AgenciaVentaCoche();
		model.addAttribute("agencia", cliente);
		model.addAttribute("titulo", "Insertar Agencia");
		model.addAttribute("ciudades", ciudadService.findAll());
		return "formAgenciaVentaCoche";
	}


	/**
	 * Metodo encargado de guardar el nuevo objeto de tipo agencia
	 * @param agencia recibe la agencia
	 * @param result el result 
	 * @param model el modelo para pasar datos a la vista
	 * @param flash pintamos de una manera rapida la vista
	 * @param status para confirmar la nueva inserciion
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/formAgencias", method = RequestMethod.POST)
	public String guardar(@Valid AgenciaVentaCoche cliente, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Insertar Agencia");
			return "formAgenciaVentaCoche";
		}
		String mensajeFlash = (cliente.getCodigo() != null) ? "Cliente editado con éxito!" : "Cliente creado con éxito!";

		agenciaService.save(cliente);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/listarAgenciaVentaCoche";
	}
}