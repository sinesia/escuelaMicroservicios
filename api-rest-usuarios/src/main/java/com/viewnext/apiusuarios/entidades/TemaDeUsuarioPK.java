package com.viewnext.apiusuarios.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

// permite q sea usada como @EmbeddedId
@Embeddable
public class TemaDeUsuarioPK implements Serializable {

	private static final long serialVersionUID = -5605757244443886858L;

	@Column(name="id_usuario")
	@NotNull
	private Integer idUsuario;
	
	@Column(name="id_tema", nullable=false)
	private Integer idTema;

	public TemaDeUsuarioPK() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TemaDeUsuarioPK(@NotNull Integer idUsuario, Integer idTema) {
		super();
		this.idUsuario = idUsuario;
		this.idTema = idTema;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdTema() {
		return idTema;
	}

	public void setIdTema(Integer idTema) {
		this.idTema = idTema;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}
