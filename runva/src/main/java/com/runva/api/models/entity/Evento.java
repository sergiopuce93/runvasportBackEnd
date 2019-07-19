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
import javax.validation.constraints.Size;

/**
 * Event entity of runvasport's data base
 * 
 * @author Sergio
 *
 */
@Entity
@Table(name = "eventos")
public class Evento {

	@Id
	@Column(name = "IDEvento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "El campo nombre es obligatorio")
	@Size(min = 2, message = "El campo nombre debe tener minimo 2 caracteres")
	@Column(name = "Nombre")
	private String name;

	@Column(name = "Url")
	private String url;

	@NotNull(message = "El campo deporte es obligatorio")
	@Size(min = 4, max = 12, message = "El campo deporte debe tener entre 4 y 12 caracteres")
	@Column(name = "DeportePrincipal")
	private String sport;

	@Column(name = "ParticipantesEstimados")
	private Integer estimatedParticipants;

	@Column(name = "LimiteParticipantes")
	private Integer limitedParticipants;

	@Temporal(TemporalType.DATE)
	@Column(name = "FechaInicio")
	private Date dateIni;

	@Temporal(TemporalType.DATE)
	@Column(name = "FechaFin")
	private Date dateEnd;

	@Temporal(TemporalType.DATE)
	@Column(name = "FechaInicioInscrip")
	private Date dateIniInscription;

	@Temporal(TemporalType.DATE)
	@Column(name = "FechaFinInscrip")
	private Date dateEndInscription;

	@Column(name = "Lugar")
	private String place;

	@Column(name = "Direccion")
	private String address;

	@Column(name = "Pais")
	private String country;

	@Column(name = "Poblacion")
	private String population;

	@Column(name = "CP")
	private Integer postalCode;

	@Column(name = "EMail")
	private String email;

	@Column(name = "EstiloVisual")
	private String visualStyle;

	@Column(name = "LimiteInscritos")
	private String limitedInscri;

	public Evento() {
		// Empty constructor
	}

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

	public String getVisualStyle() {
		return visualStyle;
	}

	public void setVisualStyle(String visualStyle) {
		this.visualStyle = visualStyle;
	}

	public String getLimitedInscri() {
		return limitedInscri;
	}

	public void setLimitedInscri(String limitedInscri) {
		this.limitedInscri = limitedInscri;
	}

}
