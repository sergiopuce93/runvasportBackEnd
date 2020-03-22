package com.backend.sport.models;

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
import javax.validation.constraints.Size;

/**
 * Event entity of runvasport's data base
 * 
 */
@Entity
@Table(name = "eventos")
public class Event {

	@Id
	@Column(name = "id_evento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "OBLIGATORIO")
	@Size(min = 2, message = "DEBE TENER AL MENOS 2 CARACTERES")
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "imagen")
	private String imagen;

	@NotNull(message = "OBLIGATORIO")
	@Column(name = "deporte_principal")
	private String sport;

	@Temporal(TemporalType.DATE)
	@NotNull(message = "OBLIGATORIO")
	@Column(name = "fecha_inicio")
	private Date dateIni;

	@Temporal(TemporalType.DATE)
	@NotNull(message = "OBLIGATORIO")
	@Column(name = "fecha_fin")
	private Date dateEnd;

	@NotNull(message = "OBLIGATORIO")
	@Column(name = "lugar")
	private String place;

	@Column(name = "direccion")
	private String address;

	@NotNull(message = "OBLIGATORIO")
	@Column(name = "pais")
	private String country;

	@NotNull(message = "OBLIGATORIO")
	@Column(name = "provincia")
	private String provincia;


	public Event() {
		// Empty constructor
	}

	/*
	 * Getters and setters
	 */

	public Integer getId() {
		return id;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return nombre;
	}

	public void setName(String name) {
		this.nombre = name;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Date getDateIni() {
		return dateIni;
	}

	public void setDateIni(Date dateIni) {
		this.dateIni = dateIni;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	

	/**
	 * Merge not null values to event
	 * 
	 * @param newEvent
	 */
	public void join(Event newEvent) {
		this.address = (newEvent.getAddress() == null) ? this.address : newEvent.getAddress();
		this.country = (newEvent.getCountry() == null) ? this.country : newEvent.getCountry();
		this.dateEnd = (newEvent.getDateEnd() == null) ? this.dateEnd : newEvent.getDateEnd();
		this.dateIni = (newEvent.getDateIni() == null) ? this.dateIni : newEvent.getDateIni();
		this.imagen = (newEvent.getImagen() == null) ? this.imagen : newEvent.getImagen();
		this.nombre = (newEvent.getName() == null) ? this.nombre : newEvent.getName();
		this.place = (newEvent.getPlace() == null) ? this.place : newEvent.getPlace();
		this.sport = (newEvent.getSport() == null) ? this.sport : newEvent.getSport();
		this.provincia = (newEvent.getProvincia() == null) ? this.provincia : newEvent.getProvincia();

	}

}
