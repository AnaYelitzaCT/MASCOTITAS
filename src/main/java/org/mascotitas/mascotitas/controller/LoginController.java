package org.mascotitas.mascotitas.controller;

import javax.servlet.ServletException;

import org.mascotitas.mascotitas.config.JwtFilter;
import org.mascotitas.mascotitas.model.Token;
import org.mascotitas.mascotitas.model.Cliente;
import org.mascotitas.mascotitas.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping (path="/api/login/")
public class LoginController {
	private final ClienteService clienteService;

	@Autowired
	public LoginController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}//constructor
// http://localhost:8080/api/login/
	@PostMapping
	public Token loginUsuario(@RequestBody Cliente cliente) throws ServletException {
		System.out.println("hola "+clienteService.validateUsuario(cliente));
		if(clienteService.validateUsuario(cliente)) {
			System.out.println("usuario válido" + cliente.getEmail());
			return new Token(generateToken(cliente.getEmail()));
		}//if
		throw new ServletException("Nombre de usuario o contraseña incorrectos");
	}//logingUsuario
	
	private String generateToken(String username) {
		Calendar calendar = Calendar.getInstance();//Fecha hora actual
		calendar.add(Calendar.HOUR, 10); // Pruebas
		//calendar.add(Calendar.MINUTE, 30);// Producción
		return Jwts.builder().setSubject(username).claim("role", "user")
		.setIssuedAt(new Date())
		.setExpiration(calendar.getTime())
		.signWith(SignatureAlgorithm.HS256, JwtFilter.secret)
		.compact();
	}//generateToken
}//class LoginController
