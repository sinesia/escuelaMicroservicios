package com.viewnext.apiusuarios.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tema_de_usuario")
public class TemaDeUsuario {
	
	@EmbeddedId
	private TemaDeUsuarioPK idsPK;
	
	@Column(name = "timestamp", 
			nullable = false, 
			updatable = false, 
			insertable = false, 
			columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;
	
	public TemaDeUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TemaDeUsuario(int idUsuario, int idTema) {
		
		this.idsPK = new TemaDeUsuarioPK(idUsuario, idTema);
	}
	
	/*
	 * public TemaDeUsuario(TemaDeUsuarioPK temaDeUsuarioPK) {
		super();
		this.temaDeUsuarioPK = temaDeUsuarioPK;
	} */

	public TemaDeUsuarioPK getIdsPK() {
		return idsPK;
	}

	public void setIdsPK(TemaDeUsuarioPK idsPK) {
		this.idsPK = idsPK;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
/*
	@ManyToOne
	@JoinColumn(name= "id_usuario", referencedColumnName = "id",
			updatable = false, 
			insertable = false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name= "id_tema", 
	referencedColumnName = "id",
	updatable = false, 
	insertable = false)
	private Tema tema;	*/
}
