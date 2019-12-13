package com.viewnext.apiusuarios.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.apiusuarios.entidades.Usuario;
import com.viewnext.apiusuarios.model.AlmacenDAOUsuarios;

@RestController()
@RequestMapping("/api")
public class UsuariosController {
	
	// Dep Injection : SPRING instancia el DAO 
	// (object, no interfaz)
	// + lo asigna al RESTcONTROLLER AL CONSTRUIRLO
	@Autowired
	private AlmacenDAOUsuarios dao;

	@RequestMapping(path = "/usuarios", method = RequestMethod.GET)
	public Usuario getUsuario () {
		
		return new Usuario(-1, "OK", "email", "passord");
	}

	@PostMapping("/usuarios")
	public Usuario crearUsuario(@RequestBody Usuario usuario) { 
		// recibe sin ID en body de peticion HTTP
		// deserializa entonces JSON A OBJETO DE TIPO USUARIO
		return dao.save(usuario); // devuelve con ID
	}
}
