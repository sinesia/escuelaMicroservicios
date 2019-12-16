package com.viewnext.apiusuarios.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Usuario implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Size(min = 1, max = 50)
	private String nombre;
	
	@NotNull
	@Size(min = 3, max = 255)
	@Pattern(regexp = "^[a-zA-z0-9._%+-]+@[a-zA-z0-9.-]+\\.[a-zA-Z]{2,6}$")
	private String email;
	
	@Size(min = 2, max = 10)
	private String password;
	
	@Column(name = "timestamp", 
			nullable = false, 
			updatable = false, 
			insertable = false, 
			columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date timestamp;
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(Integer id, String nombre, String eemail, String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = eemail;
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
