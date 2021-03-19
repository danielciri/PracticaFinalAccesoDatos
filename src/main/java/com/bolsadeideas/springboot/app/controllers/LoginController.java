package com.bolsadeideas.springboot.app.controllers;

import java.security.Principal;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
	
	@Autowired
	private MessageSource messageSource;
	
	/**
	 * Este metodo es implementado para loguearnos y asegurar que sea correcto el login
	 * ademas tambien verificamos el idioma escodigo
	 * @param error nos muestra un mensaje de error en caso de no ser un usuario existente
	 * @param logout recibe el logout
	 * @param model parametro para pasar datos a la vista 
	 * @param principal para irnos a la pagina princiapl 
	 * @param flash mostramos un mensaje en la vista 
	 * @param locale para identificar el idioma escodigo
	 * @return
	 */
	@GetMapping("/login")
	public String login(@RequestParam(value="error" , required = false)String error,@RequestParam(value="logout" , 
	required = false)String logout,
			Model model, Principal principal, RedirectAttributes flash, Locale locale) {
		
		if(principal !=null) {
			flash.addFlashAttribute("info", messageSource.getMessage("text.login.logout.info", null, locale));
			return"redirect:/";
		}
		if(error!=null) {
			model.addAttribute("error",  messageSource.getMessage("text.login.logout.error", null, locale));
		}
		if(logout!=null) {
			model.addAttribute("success",  messageSource.getMessage("text.login.logout.succes", null, locale));
			
		}
		
		return "login";
	}

}
