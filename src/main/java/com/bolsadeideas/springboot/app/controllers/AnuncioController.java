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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.bolsadeideas.springboot.app.models.entity.Anuncio;
import com.bolsadeideas.springboot.app.models.service.IAgenciaVentaCocheService;
import com.bolsadeideas.springboot.app.models.service.IAnuncioService;
import com.bolsadeideas.springboot.app.models.service.IVehiculoService;

@Controller
@SessionAttributes("anuncio")
public class AnuncioController {

	@Autowired
	private IAnuncioService clienteService;
	@Autowired
	private IAgenciaVentaCocheService ciudadService;

	@Autowired
	private IVehiculoService vehiculoService;

	@Autowired
	private MessageSource messageSource;

	
	/**
	 * Metodo implementado para listar todos los anuncios, ademas aqui tambien hacemos el paginador
	 * @param params recibe el params para el estado
	 * @param model pasamos los datos a la vista 
	 * @param locale le indicamos el idioma que hemos escogido
	 * @return nos retorna la lista de anuncio
	 */
	@RequestMapping(value = "/listarAnuncio", method = RequestMethod.GET)
	public String listar(@RequestParam Map<String, Object> params, Model model, Locale locale) {
		model.addAttribute("titulo", messageSource.getMessage("text.ciudad.listar.titulo", null, locale));
		model.addAttribute("agencias", clienteService.findAll());
		int page = params.get("page") != null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0;

		PageRequest pageRequest = PageRequest.of(page, 2);

		Page<Anuncio> pagePersona = clienteService.getAll(pageRequest);

		int totalPage = pagePersona.getTotalPages();
		if (totalPage > 0) {
			List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
			model.addAttribute("pages", pages);
		}

		model.addAttribute("list", pagePersona.getContent());
		model.addAttribute("current", page + 1);
		model.addAttribute("next", page + 2);
		model.addAttribute("prev", page);
		model.addAttribute("last", totalPage);

		return "listarAnuncio";
	}

	/**
	 * Metodo para crear un anuncio
	 * @param model pasamos los datos a la vista
	 * @return nos retorna el formulario
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/formAnuncio")
	public String crear(Model model) {

		Anuncio cliente = new Anuncio();
		model.addAttribute("anuncio", cliente);
		model.addAttribute("titulo", "Insertar Anuncio");
		model.addAttribute("agencias", ciudadService.findAll());
		model.addAttribute("vehiculos", vehiculoService.findAll());
		return "formAnuncio";
	}

	/**
	 * Metodo implementado para editr
	 * @param codigo recibe el codigo del anuncio a edir
	 * @param model modelo para pasar los datos a la vista
	 * @param flash mostramos un mensaje de manera rapida 
	 * @return nos retorna a la vista que deseemos
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/formAnuncio/{id}")
	public String editar(@PathVariable(value = "id") Long codigo, Model model, RedirectAttributes flash) {

		Anuncio cliente = null;

		if (codigo > 0) {
			cliente = clienteService.findOne(codigo);
			if (cliente == null) {
				flash.addFlashAttribute("error", "El ID del anuncio no existe en la BBDD!");
				return "redirect:/listarAnuncio";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del anuncio no puede ser cero!");
			return "redirect:/listarAnuncio";
		}
		model.addAttribute("anuncio", cliente);
		model.addAttribute("titulo", "Editar Cliente");
		model.addAttribute("agencias", ciudadService.findAll());
		model.addAttribute("vehiculos", vehiculoService.findAll());
		return "formAnuncio";
	}

	/**
	 * Metodo implementado para guardar nuestro anuncio
	 * 
	 * @param anuncio recibe el anuncio a crear
	 * @param result  el result
	 * @param model   el modelo para pasar datos a la vista
	 * @param flash   mostrar un mensaje de manera rapida
	 * @param status  le indicamos el status del objeto
	 * @return nos retorna la vista de lista de anuncios
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/formAnuncio", method = RequestMethod.POST)
	public String guardar(@Valid Anuncio cliente, BindingResult result, Model model, RedirectAttributes flash,
			SessionStatus status) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Insertar Anuncio");
			return "formAnuncio";
		}
		String mensajeFlash = (cliente.getCodigoAnuncio() != null) ? "Anuncio Eliminado con exito!"
				: "Cliente creado con éxito!";

		clienteService.save(cliente);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/listarAnuncio";
	}

	/**
	 * Metodo implementado para eliminar nuestro de anuncio
	 * 
	 * @param codigoAnuncio recibe el codigo del anuncio a eliminar
	 * @param flash         y mostramos un mensaje indicando que se ha eliminado
	 *                      correctamente
	 * @return nos retorna la vista
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/eliminarAnuncio/{codigoAnuncio}")
	public String eliminar(@PathVariable(value = " codigoAnuncio") long codigoAnuncio, RedirectAttributes flash) {

		if (codigoAnuncio > 0) {
			clienteService.delete(codigoAnuncio);
			flash.addFlashAttribute("success", "Anuncio eliminado con éxito!");
		}
		return "redirect:/listarAnuncio";
	}
}