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
import com.bolsadeideas.springboot.app.models.dao.ICiudadDao;
import com.bolsadeideas.springboot.app.models.entity.Ciudad;
import com.bolsadeideas.springboot.app.models.service.ICiudadService;
import com.bolsadeideas.springboot.app.models.service.IPaisService;

@Controller
@SessionAttributes("ciudades")
public class CiudadesController {

	@Autowired
	private ICiudadService ciudadService;
	@Autowired
	private IPaisService paisService;
	@Autowired
	private ICiudadDao ciudadDao;
	
	@Autowired
	private MessageSource messageSource;

	/**
	 * Metodo implementado para listar todas las ciudade, ademas tambien hacemos el paginador de esta lista 
	 * @param params pasamos params
	 * @param model pasamos los datos a la vista
	 * @param locale el locale para saber el idioma de la pagina
	 * @return
	 */
	@RequestMapping(value = "/listarCiudades", method = RequestMethod.GET)
	public String listar(@RequestParam Map<String, Object> params,Model model,Locale locale) {
		model.addAttribute("titulo", messageSource.getMessage("text.ciudad.listar.titulo", null, locale));
		model.addAttribute("agencias", ciudadService.findAll());
	int page = params.get("page") != null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0;
		
		PageRequest pageRequest = PageRequest.of(page, 2);
		
		Page<Ciudad> pagePersona = ciudadService.getAll(pageRequest);
		
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
		
		return "listarCiudades";
	}
	
	/**
	 * Metodo implementado para crear el objeto
	 * @param model le pasamos daots a la vista mediante model
	 * @return nos retorna el formulario
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/formCiudades")
	public String crear(Model model) {

		Ciudad cliente = new Ciudad();
		model.addAttribute("ciudad", cliente);
		model.addAttribute("titulo", "Crear Pais");
		model.addAttribute("paises", paisService.findAll());
		return "formCiudades";
	}
	
	/**
	 * Metodo encargado de editar el objeto qde tipo ciudad
	 * @param codigo recibe el codigo de el objeto a editar
	 * @param model le pasamos el model para pasar datos a la vista 
	 * @param flash mostramos un mensaje en la vista de manera rapida 
	 * @return nos retorna la vista de formulario
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/formCiudades/{id}")
	public String editar(@PathVariable(value = "id") Long codigo,Model model, RedirectAttributes flash) {

		Ciudad cliente = null;

		if (codigo !=null ) {
			cliente = ciudadService.findOne(codigo);
			if (cliente == null) {
				flash.addFlashAttribute("error", "El ID de la ciudad no existe en la BBDD!");
				return "redirect:/listarCiudades";
			}
		} else {
			flash.addFlashAttribute("error", "El ID de la ciudad no puede ser cero!");
			return "redirect:/listarCiudades";
		}
		model.addAttribute("ciudad", cliente);
		model.addAttribute("titulo", "Editar Cliente");
		model.addAttribute("paises", paisService.findAll());
		return "formCiudades";
	}
	/**
	 * Metodo implementado para guardar el objeto creado
	 * @param ciudad recibe el objeto que va a crear 
	 * @param result el result
	 * @param model manda los datos a la vista es decir al html
	 * @param flash muestra un mensaje en la vista 
	 * @param status completado el estado del objeto
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/formCiudades", method = RequestMethod.POST)
	public String guardar(@Valid Ciudad cliente, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Crear Ciudad");
			return "formCiudades";
		}
		String mensajeFlash = (cliente.getCodigoPostal() != null) ? "Ciudad editado con éxito!" : "Ciudad creado con éxito!";

		ciudadService.save(cliente);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/listarCiudades";
	}
	
	
	/**
	 * Metodo implementado para eliminar ciudades
	 * @param codigoPostal recibe el codigo postal de la ciudad a eliminar(la clave primari)
	 * @param flash muestra un mensaje flash
	 * @return nos retorna la vista de list
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/eliminarCiudad/{idCiudad}" , method = RequestMethod.GET)
	public String eliminar(@PathVariable (value = "idCiudad") Long codigoPostal, RedirectAttributes flash) {
		if (codigoPostal > 0) {
			ciudadService.delete(codigoPostal);
			flash.addFlashAttribute("success", "Ciudad eliminado con éxito!");
		}
		return "redirect:/listarCiudades";
	}
}