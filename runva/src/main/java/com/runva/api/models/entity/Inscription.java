package com.runva.api.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.persistence.ForeignKey;

/**
 * Inscription entity of runvasport's data base
 *
 */
@Entity
@Table(name = "inscripciones")
public class Inscription {

	@Id
	@Column(name = "id_inscripcion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(targetEntity = Inscription.class)
	@JoinColumn(name = "usuario", foreignKey = @ForeignKey(name = "usuario"))
	@NotNull(message = "El campo usuario es obligatorio")
	private Integer idUsuario;

	@NotNull(message = "El campo inscriptiono es obligatorio")
	@ManyToOne(targetEntity = Inscription.class)
	@JoinColumn(name = "evento", foreignKey = @ForeignKey(name = "evento"))
	@NotNull(message = "El campo evento es obligatorio")
	private Integer idEvento;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha")
	private Date date;

	public Inscription() {
		// Empty constructor
	}

	/*
	 * Getters and setters
	 */

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

	/**
	 * Merge not null values to inscription
	 * 
	 * @param newInscription
	 */
	public void join(Inscription newInscription) {

		this.date = (newInscription.getDate() == null) ? this.date : newInscription.getDate();
		this.idEvento = (newInscription.getIdEvento() == null) ? this.idEvento : newInscription.getIdEvento();
		this.idUsuario = (newInscription.getIdUsuario() == null) ? this.idUsuario : newInscription.getIdUsuario();

	}
}
