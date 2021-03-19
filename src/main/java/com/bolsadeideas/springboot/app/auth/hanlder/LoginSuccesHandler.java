package com.bolsadeideas.springboot.app.auth.hanlder;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.support.SessionFlashMapManager;

/**
 * 
 * @author Daniel Cirilo
 *
 */
@Component
public class LoginSuccesHandler extends SimpleUrlAuthenticationSuccessHandler {

	/**
	 * Metodo implementado para darle la bienvenida a el usuario con su respectivo nombre 
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		SessionFlashMapManager flashMapManager = new SessionFlashMapManager();
		FlashMap flashMap = new FlashMap();
		flashMap.put("success", "Hola " + authentication.getName() + ",has iniciado sesion con exito");
		flashMapManager.saveOutputFlashMap(flashMap, request, response);
		if(authentication!=null) {
			logger.info("el usuario '"+ authentication.getName() + "' ha iniciado sesion con exito");
		}
		super.onAuthenticationSuccess(request, response, authentication);
	}
	
	

}
