package com.bolsadeideas.springboot.app.controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LocaleController {
	
	/**
	 * Este metodo lo implementamos para controlar que en nuestro url se vaya al s
	 * @param request
	 * @return
	 */
	@GetMapping("/locale")
	public String locale(HttpServletRequest request) {
		String ultimaUrl = request.getHeader("referer");
		return "redirect:".concat(ultimaUrl);
	}

}
