package com.bolsadeideas.springboot.app.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.bolsadeideas.springboot.app.models.entity.Vehiculo;
import com.bolsadeideas.springboot.app.models.service.IAgenciaVentaCocheService;
import com.bolsadeideas.springboot.app.models.service.IVehiculoService;

@Controller
@SessionAttributes("cliente")
public class VehiculoController {

	@Autowired
	private IVehiculoService clienteService;
	@Autowired
	private IAgenciaVentaCocheService ciudadService;
	
	@Autowired
	private MessageSource messageSource;
	
	/**
	 * Metodo implementado para listar los vehiculos de nuestra base de datos y tambien cambiar el idioma
	 * y  mostrar el paginador
	 * @param params reciben params 
	 * @param model modelo para pasar los datos a la vista 
	 * @param locale recibe el idioma a cambiar
	 * @return nos retorna la vista 
	 */
	@RequestMapping(value = "/listarVehiculo", method = RequestMethod.GET)
	public String listar(@RequestParam Map<String, Object> params,Model model, Locale locale) {

		model.addAttribute("titulo", messageSource.getMessage("text.vehiculo.listar.titulo", null, locale));
		model.addAttribute("agencias", clienteService.findAll());
		int page = params.get("page") != null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0;
		
		PageRequest pageRequest = PageRequest.of(page, 2);
		
		Page<Vehiculo> pagePersona = clienteService.getAll(pageRequest);
		
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

		
		return "listarVehiculo";
	}
	
	/**
	 * Metodo implementado para crear un vehiculo
	 * @param model pasamos el model para pasar los datos a la vista
	 * @return nos retorna la vista
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/formVehiculo")
	public String crear(Model model) {

		Vehiculo cliente = new Vehiculo();
		model.addAttribute("vehiculo", cliente);
		model.addAttribute("titulo", "Insertar vehiculos");
		model.addAttribute("agencias", ciudadService.findAll());
		return "formVehiculo";
	}
	
	/**
	 * Metodo implementado visualizar el detalle del vehiculo es decir
	 * podremos observar la foto si es que posee
	 * @param id pasamos el id del vehiculo del cual queremos ver dicho detalle 
	 * @param model model pasamos datos a la vista 
	 * @return retornamos la vista de ver 
	 */
	@Secured("ROLE_USER")
	@GetMapping(value="/verVehiculo/{id}")
	public String ver(@PathVariable(value="id")Long id,Map<String,Object> model,RedirectAttributes flash) {
		Vehiculo pais = clienteService.findOne(id);
		if(pais==null) {
			flash.addFlashAttribute("error","El Vehiculo no existe en nuestra base de datos");
			return "redirect:/listarVehiculo";
		}
		model.put("vehiculo",pais);
		model.put("titulo","detalle vehiculo:" + pais.getMarca());
		return"verVehiculo";
	}

	/**
	 * Editamos el vehiculo
	 * @param numeroOferta recogemos el numero de oferta del vehiculo a editar
	 * @param model model para pasar datos a la vista 
	 * @param flash mostramos un mensaje en la vista 
	 * @return retornamos la lista 
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/formVehiculo/{id}")
	public String editar(@PathVariable(value = "id") Long numeroOferta,Model model, RedirectAttributes flash) {

		Vehiculo cliente = null;
		
		if (numeroOferta > 0) {
			cliente = clienteService.findOne(numeroOferta);
			if (cliente == null) {
				flash.addFlashAttribute("error", "El ID del vehiculo no existe en la BBDD!");
				return "redirect:/listarVehiculo";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del vehiculo no puede ser cero!");
			return "redirect:/listarVehiculo";
		}
		model.addAttribute("vehiculo", cliente);
		model.addAttribute("titulo", "Editar Cliente");
		model.addAttribute("agencias", ciudadService.findAll());
		return "formVehiculo";
	}
	
	/**
	 * Metodo implementado para guardar vehiculos  
	 * @param vehiculo recibe el objeto vehiclo 
	 * @param result recibe el result
	 * @param model recibe models para pasar datos a la vista 
	 * @param foto recibe la foto a subir
	 * @param flash mostramos el mensaje en la vista 
	 * @param status completamos el estado
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/formVehiculo", method = RequestMethod.POST)
	public String guardar(@Valid Vehiculo cliente, BindingResult result, Model model, @RequestParam("file") MultipartFile foto, RedirectAttributes flash, SessionStatus status) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Insertar Agencia");
			return "formVehiculo";
		}
		String mensajeFlash = (cliente.getNumeroOferta() !=null) ? "Cliente editado con éxito!" : "Cliente creado con éxito!";
		if(!foto.isEmpty()) {
			
			Path directPath = Paths.get("src//main//resources//static/uploads");
			String rootPath = directPath.toFile().getAbsolutePath();
			try {
				byte[] bytes = foto.getBytes();
				Path rutaCompleta = Paths.get(rootPath+"//"+foto.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				flash.addFlashAttribute("info","has subido correctamente el archivo"+ foto.getOriginalFilename());
				cliente.setFoto(foto.getOriginalFilename());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		clienteService.save(cliente);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listarVehiculo";
	}
	
	/**
	 * Metodo implementado para eliminar vehiculos de nuestra base de datos
	 * @param numeroOferta recibe el numero de oferta del vehiculo
	 * @param flash muestra un emnsaje rapido indicando que se ha eliminado
	 * @return nos retorna a la vista de la lista
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/eliminarVehiculo/{idVehiculo}")
	public String eliminar(@PathVariable(value = "idVehiculo") Long numeroOferta, RedirectAttributes flash) {

		if (numeroOferta > 0) {
			clienteService.delete(numeroOferta);
			flash.addFlashAttribute("success", "Vehiculo eliminado con éxito!");
		}
		return "redirect:/listarVehiculo";
	}
}