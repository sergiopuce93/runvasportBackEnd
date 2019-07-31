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
 * Organizer entity of runvasport's data base
 *
 */

@Entity
@Table(name = "serviciosorganizadores")
public class Organizer {

	@Id
	@Column(name = "id_servicio")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nombre")
	private String name;

	@Column(name = "descripcion")
	private String description;

	@Column(name = "enlace_interes")
	private String interest_link;


	public Organizer() {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInterestLink() {
		return interest_link;
	}

	public void setInterestLink(String interest_link) {
		this.interest_link = interest_link;
	}

	/**
	 * Merge not null values to user
	 * 
	 * @param newOrganizer
	 */
	public void join(Organizer newOrganizer) {
		
		this.name = (newOrganizer.getName() == null) ? this.name : newOrganizer.getName();
		this.description = (newOrganizer.getDescription() == null) ? this.description : newOrganizer.getDescription();
		this.interest_link = (newOrganizer.getInterestLink() == null) ? this.interest_link : newOrganizer.getInterestLink();
		
		
	}

}