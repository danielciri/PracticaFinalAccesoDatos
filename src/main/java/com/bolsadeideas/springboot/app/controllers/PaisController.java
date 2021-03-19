package com.bolsadeideas.springboot.app.controllers;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.bolsadeideas.springboot.app.models.entity.Pais;
import com.bolsadeideas.springboot.app.models.service.IPaisService;

@Controller
@SessionAttributes("pais")
public class PaisController {

	@Autowired
	private IPaisService paisService;
	
	@Autowired
	private MessageSource messageSource;

	/**
	 * Metodo encargado de cargar el detalle del pais 
	 * es decir la bandera del pais escogido
	 * @param nombre nombre del pais 
	 * @param model pasamos los datos a la vista mediante model
	 * @param flash mostramos un mensaje en la vista 
	 * @return
	 */
	@Secured("ROLE_USER")
	@GetMapping(value="/verPais/{nombre}")
	public String ver(@PathVariable(value="nombre")String nombre,Map<String,Object> model,RedirectAttributes flash) {
		Pais pais = paisService.findOne(nombre);
		if(pais==null) {
			flash.addFlashAttribute("error","El cliente no existe en la base de datos");
			return "redirect:/listarPais";
		}
		model.put("pais",pais);
		model.put("titulo","detalle pais:" + pais.getNombre());
		return"verPais";
	}
	
	/**
	 * Metodo encargado de listar todos los datos de nuestra base de datos
	 * @param params recibe params 
	 * @param model pasamos datos a la vista 
	 * @param locale recibe el locale para saber el idioma
	 * @return nos retorna la vista de la lista 
	 */
	@RequestMapping(value = "/listarPais", method = RequestMethod.GET)
		public String listar(@RequestParam Map<String, Object> params,Model model, Locale locale) {
		model.addAttribute("titulo", messageSource.getMessage("text.pais.listar.titulo", null, locale));
			model.addAttribute("agencias", paisService.findAll());
		int page = params.get("page") != null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0;
			
			PageRequest pageRequest = PageRequest.of(page, 2);
			
			Page<Pais> pagePersona = paisService.getAll(pageRequest);
			
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
		return "listarPais";
	}
	
}