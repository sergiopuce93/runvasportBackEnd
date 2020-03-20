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

	@Column(name = "url")
	private String url;

	@Column(name = "imagen")
	private String imagen;

	@NotNull(message = "OBLIGATORIO")
	@Column(name = "deporte_principal")
	private String sport;

	@NotNull(message = "OBLIGATORIO")
	@Column(name = "participantes_estimado")
	private Integer estimatedParticipants;

	@Column(name = "limite_participantes")
	private Integer limitedParticipants;

	@Temporal(TemporalType.DATE)
	@NotNull(message = "OBLIGATORIO")
	@Column(name = "fecha_inicio")
	private Date dateIni;

	@Temporal(TemporalType.DATE)
	@NotNull(message = "OBLIGATORIO")
	@Column(name = "fecha_fin")
	private Date dateEnd;

	@Temporal(TemporalType.DATE)
	@NotNull(message = "obligatory")
	@Column(name = "fecha_inicio_inscrip")
	private Date dateIniInscription;

	@Temporal(TemporalType.DATE)
	@NotNull(message = "obligatory")
	@Column(name = "fecha_fin_inscrip")
	private Date dateEndInscription;

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
	
	@Column(name = "poblacion")
	private String population;

	@Column(name = "cp")
	private Integer postalCode;

	@Column(name = "email")
	private String email;

	@Column(name = "clasificacion")
	private String clasification;

	@Column(name = "limite_inscritos")
	private String limitedInscri;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public Integer getEstimatedParticipants() {
		return estimatedParticipants;
	}

	public void setEstimatedParticipants(Integer estimatedParticipants) {
		this.estimatedParticipants = estimatedParticipants;
	}

	public Integer getLimitedParticipants() {
		return limitedParticipants;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getClasification() {
		return clasification;
	}

	public void setClasification(String clasification) {
		this.clasification = clasification;
	}

	public void setLimitedParticipants(Integer limitedParticipants) {
		this.limitedParticipants = limitedParticipants;
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

	public Date getDateIniInscription() {
		return dateIniInscription;
	}

	public void setDateIniInscription(Date dateIniInscription) {
		this.dateIniInscription = dateIniInscription;
	}

	public Date getDateEndInscription() {
		return dateEndInscription;
	}

	public void setDateEndInscription(Date dateEndInscription) {
		this.dateEndInscription = dateEndInscription;
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

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public Integer getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLimitedInscri() {
		return limitedInscri;
	}

	public void setLimitedInscri(String limitedInscri) {
		this.limitedInscri = limitedInscri;
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
		this.dateEndInscription = (newEvent.getDateEndInscription() == null) ? this.dateEndInscription
				: newEvent.getDateEndInscription();
		this.dateIni = (newEvent.getDateIni() == null) ? this.dateIni : newEvent.getDateIni();
		this.dateIniInscription = (newEvent.getDateIniInscription() == null) ? this.dateIniInscription
				: newEvent.getDateIniInscription();
		this.email = (newEvent.getEmail() == null) ? this.email : newEvent.getEmail();
		this.estimatedParticipants = (newEvent.getEstimatedParticipants() == null) ? this.estimatedParticipants
				: newEvent.getEstimatedParticipants();
		this.imagen = (newEvent.getImagen() == null) ? this.imagen : newEvent.getImagen();
		this.limitedInscri = (newEvent.getLimitedInscri() == null) ? this.limitedInscri : newEvent.getLimitedInscri();
		this.limitedParticipants = (newEvent.getLimitedParticipants() == null) ? this.limitedParticipants
				: newEvent.getLimitedParticipants();
		this.nombre = (newEvent.getName() == null) ? this.nombre : newEvent.getName();
		this.place = (newEvent.getPlace() == null) ? this.place : newEvent.getPlace();
		this.population = (newEvent.getPopulation() == null) ? this.population : newEvent.getPopulation();
		this.postalCode = (newEvent.getPostalCode() == null) ? this.postalCode : newEvent.getPostalCode();
		this.sport = (newEvent.getSport() == null) ? this.sport : newEvent.getSport();
		this.url = (newEvent.getUrl() == null) ? this.url : newEvent.getUrl();
		this.provincia = (newEvent.getProvincia() == null) ? this.provincia : newEvent.getProvincia();

	}

}
