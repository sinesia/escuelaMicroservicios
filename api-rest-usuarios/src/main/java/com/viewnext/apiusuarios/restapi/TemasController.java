package com.viewnext.apiusuarios.restapi;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.apiusuarios.entidades.Tema;
import com.viewnext.apiusuarios.entidades.Usuario;
import com.viewnext.apiusuarios.model.AlmacenDAOTemas;
import com.viewnext.apiusuarios.model.AlmacenDAOUsuarios;

@RestController()
@RequestMapping("/api/temas")
public class TemasController {
	
	// Dep Injection : SPRING instancia el DAO 
	// (object, no interfaz)
	// + lo asigna al RESTcONTROLLER AL CONSTRUIRLO
	@Autowired
	private AlmacenDAOTemas dao;

	@PostMapping()
	public Tema crearTema(@RequestBody Tema tema) { 
		// recibe sin ID en body de peticion HTTP
		// deserializa entonces JSON A OBJETO DE TIPO TEMA
		return dao.save(tema); // devuelve con ID
	}
	
	@PostMapping(value="/lista") 
	public List<Tema> crearVariosTemas(@RequestBody List<Tema> temasList) { 
		// recibe sin ID en body de peticion HTTP
		// deserializa entonces JSON A OBJETO DE TIPO TEMA
		return dao.saveAll(temasList);
	}
	
	@PostMapping(value="/formulario") 
	// subruta formulario 
	// porq raiz con POST
	// esta usada
	public Tema crearTemaPorParam(
			// @RequestParam Integer id,
			@RequestParam (name="nombreTema") String elNombreDelTema,
			@RequestParam String descripcion) { 

		Tema tema = new Tema(null, elNombreDelTema, descripcion, null);
		System.out.println("ELIMINAR ID RECIBIDO ");
		return dao.save(tema); // devuelve con ID
	}
	
	@RequestMapping(value = "/{id}", method = {RequestMethod.GET})
	public Tema getTema(@PathVariable Integer id) {
		System.out.println("ID RECIBIDO " + id);
		Optional<Tema> tema = dao.findById(id);
		return tema.orElse(null);
	}

	@RequestMapping(method = {RequestMethod.PUT})
	public Tema modificarTema(@RequestBody Tema tema) {
		return dao.save(tema);
	}
	
	@RequestMapping(value = "/{id}", method = {RequestMethod.PUT})
	public Tema modificarTema(@PathVariable Integer id, 
										@RequestBody Tema tema) {
		System.out.println(">>>>>>>>> MODIFICAR ID RECIBIDO " + id);

		tema.setId(id);
		return dao.save(tema);
	}
	
	@GetMapping
	public List<Tema> leerTodos() {
		
		return dao.findAll();
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminarTema(@PathVariable Integer id) {
		
		System.out.println(">>>>>>>>> DELETE ID RECIBIDO " + id);
		
		dao.deleteById(id);
	}
	
	@DeleteMapping()
	public void eliminarTema(@RequestBody Tema tema) {
		
		System.out.println(">>>>>>>>> DELETE " );
		dao.delete(tema);
	}	
}
