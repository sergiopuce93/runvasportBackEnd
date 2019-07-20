package com.runva.api.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * Event entity of runvasport's data base
 * 
 * @author Sergio
 *
 */
@Entity
@Table(name = "inscripciones")
public class Inscription {

	@Id
	@Column(name = "IDLista")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "El campo usuario es obligatorio")
	@Column(name = "Usuario")
	private Integer idUsuario;

	@NotNull(message = "El campo evento es obligatorio")
	@Column(name = "Event")
	private Integer idEvento;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "Fecha")
	private Date date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	

}
