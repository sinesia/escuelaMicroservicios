package com.viewnext.apiusuarios.restapi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.apiusuarios.entidades.Usuario;
import com.viewnext.apiusuarios.model.AlmacenDAOUsuarios;



@RestController()
@RequestMapping("/api/usuarios")
public class UsuariosController {
	
	// Dep Injection : SPRING instancia el DAO 
	// (object, no interfaz)
	// + lo asigna al RESTcONTROLLER AL CONSTRUIRLO
	@Autowired
	private AlmacenDAOUsuarios dao;

	@PostMapping()
	public Usuario crearUsuario(@RequestBody Usuario usuario) { 
		// recibe sin ID en body de peticion HTTP
		// deserializa entonces JSON A OBJETO DE TIPO USUARIO
		return dao.save(usuario); // devuelve con ID
	}
	
	@PostMapping(value="/formulario") 
	// subruta formulario 
	// porq raiz con POST
	// esta usada
	public Usuario crearUsuarioPorParam(
			// @RequestParam Integer id,
			@RequestParam (name="nombre") String elNombreDelUsu,
			@RequestParam String email,
			@RequestParam String password) { 

		Usuario usu = new Usuario(null, elNombreDelUsu, email, password);
		System.out.println("ELIMINAR ID RECIBIDO ");
		return dao.save(usu); // devuelve con ID
	}
	
	@RequestMapping(value = "/{id}", method = {RequestMethod.GET})
	public Usuario getUsuario(@PathVariable Integer id) {
		System.out.println("ID RECIBIDO " + id);
		Optional<Usuario> usu = dao.findById(id);
		return usu.orElse(null);
	}

	@RequestMapping(method = {RequestMethod.PUT})
	public Usuario modificarUsuario(@RequestBody Usuario usuario) {
		
		System.out.println(">>>>>>>>> MODIFICAR ID RECIBIDO ");

		return dao.save(usuario);
	}
	
	@RequestMapping(value = "/{id}", method = {RequestMethod.PUT})
	public Usuario modificarUsuario(@PathVariable Integer id, 
										@RequestBody Usuario usuario) {
		
		System.out.println(">>>>>>>>> MODIFICAR ID RECIBIDO " + id);

		usuario.setId(id);
		return dao.save(usuario);
	}
	
	@GetMapping
	public List<Usuario> leerTodos() {
		
		return dao.findAll();
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminarUsuario(@PathVariable Integer id) {
		
		System.out.println(">>>>>>>>> DELETE ID RECIBIDO " + id);
		
		dao.existsById(id);
	}
	
	@DeleteMapping()
	public void eliminarUsuario(@RequestBody Usuario usuario) {
		
		System.out.println(">>>>>>>>> DELETE " );
		
		dao.delete(usuario);
	}
	
	
}
