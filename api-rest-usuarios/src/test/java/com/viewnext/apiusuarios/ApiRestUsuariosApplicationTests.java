package com.viewnext.apiusuarios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.viewnext.apiusuarios.entidades.Tema;
import com.viewnext.apiusuarios.entidades.Usuario;
import com.viewnext.apiusuarios.model.AlmacenDAOTemas;
import com.viewnext.apiusuarios.model.AlmacenDAOTemasDeUsuarios;
import com.viewnext.apiusuarios.model.AlmacenDAOUsuarios;

@SpringBootTest
class ApiRestUsuariosApplicationTests {
	
	// Spring hace un daoTemas
	// + lo asigna autmaticamente a esta variable
	// esto es DI (=DEPENDENCY INJECTION)
	@Autowired
	private AlmacenDAOTemas daoTemas;
	
	@Autowired
	private AlmacenDAOUsuarios daoUsu;

	@Test
	void testTemaPreferido() throws InterruptedException {
		Thread.sleep(1000);
		Tema tema = daoTemas.findById(1).orElse(null);
		assertEquals(1, tema.getId());
		assertNotEquals(0, tema.getNombre().length()); 
		
		Usuario usu = daoUsu.findById(1).orElse(null);
		// No solo busca registro de usuario (SELECT * FROM USUARIO ....)
		// e instancia new usuario()
		//mapeando campos de tabla a variables miembro (=propiedades)
		//hace lo mismo, en esta llamada, con propiedad usu.temaPreferido con Tema
		// por las anotaciones @ManyToOne y @JoinColumn
		// es decir, hace otro SELECT * FROM TEMA WHERE ...
		// e instancia un new Tema() + mapea 
		assertNotNull(usu);
		
		usu.setIdTemaPreferido(tema.getId());
		
		// usu
		usu = daoUsu.saveAndFlush(usu);
		daoUsu.flush();
		usu = daoUsu.findById(1).orElse(null);
		
		Integer idTemaPref = usu.getIdTemaPreferido();
		assertEquals(tema.getId(), idTemaPref);
			
		Tema temaPref = usu.getTemaPreferido();
		assertEquals(tema.getNombre(), temaPref.getNombre());
		
		List<Usuario> usuariosPref = tema.getUsuariosPref();
		for (Usuario usuario : usuariosPref) {
			System.out.println("Usuario : " + usuario.getNombre()
			+ " prefiere : " + tema.getNombre());
		}
		assertNotEquals(0, usuariosPref.size());
	}

	private void assertNotNull(Usuario usu) {
		// TODO Auto-generated method stub
		
	}
}
