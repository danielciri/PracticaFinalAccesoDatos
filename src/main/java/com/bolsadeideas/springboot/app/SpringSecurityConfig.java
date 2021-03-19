package com.bolsadeideas.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.bolsadeideas.springboot.app.auth.hanlder.LoginSuccesHandler;
import com.bolsadeideas.springboot.app.models.service.JpaUserDetailService;




@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	
	@Autowired
	private LoginSuccesHandler loginSuccesHandler;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private JpaUserDetailService userDetailsService;
	
	
	/**
	 * Metodo encargado de restringir acceso a las paginas que un usuario  comun no pueda ingresa
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/","/css/**","/js/**","/images/**","/listar","/listarAgencias","/listarVehiculo","/listarAnuncio","/listarCiudades","/listarPais","/locale","/listCiudad","/listVehiculo","/listAgencia","/listPais","/listAnuncio").permitAll()

		.anyRequest().authenticated()
		.and()
		.formLogin()
		.successHandler(loginSuccesHandler)
		.loginPage("/login")
		.permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/error_403");
		//Quede por el video 8
		
	}

		
	
	/**
	 * Metodo que sen encarga chequear el passwrod encriptado
	 * @param builder reciben un builder para enviar el passwrod
	 * @throws Exception
	 */
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception {
		
		builder.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder);
	

	}

}
