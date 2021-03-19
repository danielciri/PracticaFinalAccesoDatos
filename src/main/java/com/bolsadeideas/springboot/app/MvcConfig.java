package com.bolsadeideas.springboot.app;



import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


@Configuration
public class MvcConfig implements WebMvcConfigurer{
	
	/**
	 * Registramos la vista y mostramos un mensaje de error 
	 */
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/error_403").setViewName("error_403");
	}
	/**
	 * Metodo implementado para encriptar la contrasena y enviarla a la base de datos encriptada correctamente 
	 * @return nos retorna el password encriptado
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/**
	 * Metodo implementado para asignar un idioma por defecto a nuestra pagina 
	 * en este caso sera el espanol 
	 * @return nos retorna el idioma por defecto 
	 */
	@Bean(name="localeResolver")
	public LocaleResolver localResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(new Locale("es","ES"));
		return localeResolver;
	}
	
	/**
	 * Metodo implementado para saber cuando debemos cambiar de idioma.
	 * @return nos retorna el dioma seleccionado
	 */
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
		localeInterceptor.setParamName("lang");
		return localeInterceptor;
	}
	
	/**
	 * registramos el idioma seleccionado.
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor((localeChangeInterceptor()));
	}

	
}
