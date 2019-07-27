package com.runva.api.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User entity of runvasport's data base
 * 
 * @author Sergio
 *
 */
@Entity
@Table(name = "usuarios")
public class User {

	@Id
	@Column(name = "IDUsuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "Usuario")
	private String username;

	@Column(name = "Nombre")
	private String name;
	
	@Column(name = "Apellidos")
	private String surnames;
	
	@Column(name = "Pais")
	private String country;
	
	@Column(name = "Provincia")
	private String provincia;
	
	@Column(name = "Poblacion")
	private String poblation;
	
	@Column(name = "CP")
	private Integer cp;
	
	@Column(name = "Direccion")
	private String address;
	
	@Column(name = "PaginaWEB")
	private String web;
	
	@Column(name = "Facebook")
	private String facebook;
	
	@Column(name = "Twitter")
	private String twitter;
	
	@Column(name = "Idioma")
	private String language;
	
	@Column(name = "PersonaContacto")
	private Integer contactPerson;
	
	@Column(name = "TlfFijo")
	private Integer telephone;
	
	@Column(name = "TlfMovil")
	private Integer movil;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Administrador")
	private Integer admin;

	public User() {
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPoblation() {
		return poblation;
	}

	public void setPoblation(String poblation) {
		this.poblation = poblation;
	}

	public Integer getCp() {
		return cp;
	}

	public void setCp(Integer cp) {
		this.cp = cp;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Integer getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(Integer contactPerson) {
		this.contactPerson = contactPerson;
	}

	public Integer getTelephone() {
		return telephone;
	}

	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}

	public Integer getMovil() {
		return movil;
	}

	public void setMovil(Integer movil) {
		this.movil = movil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAdmin() {
		return admin;
	}

	public void setAdmin(Integer admin) {
		this.admin = admin;
	}
	
	/**
	 * Merge not null values to user
	 * 
	 * @param newUser
	 */
	public void join(User newUser) {
		
		this.address = (newUser.getAddress() == null) ? this.address : newUser.getAddress();
		this.country = (newUser.getCountry() == null) ? this.country : newUser.getCountry();
		this.contactPerson = (newUser.getContactPerson() == null) ? this.contactPerson : newUser.getContactPerson();
		this.country = (newUser.getCountry() == null) ? this.country : newUser.getCountry();
		this.cp = (newUser.getCp() == null) ? this.cp : newUser.getCp();
		this.email = (newUser.getEmail() == null) ? this.email : newUser.getEmail();
		this.facebook = (newUser.getFacebook() == null) ? this.facebook : newUser.getFacebook();
		this.language = (newUser.getLanguage() == null) ? this.language : newUser.getLanguage();
		this.movil = (newUser.getMovil() == null) ? this.movil : newUser.getMovil();
		this.name = (newUser.getName() == null) ? this.name : newUser.getName();
		this.poblation = (newUser.getPoblation() == null) ? this.poblation : newUser.getPoblation();
		this.provincia = (newUser.getProvincia() == null) ? this.provincia : newUser.getProvincia();
		this.surnames = (newUser.getSurnames() == null) ? this.surnames : newUser.getSurnames();
		this.telephone = (newUser.getTelephone() == null) ? this.telephone : newUser.getTelephone();
		this.twitter = (newUser.getTwitter() == null) ? this.twitter : newUser.getTwitter();
		this.username = (newUser.getUsername() == null) ? this.username : newUser.getUsername();
		this.web = (newUser.getWeb() == null) ? this.web : newUser.getWeb();
		
		
	}
	
	
	
	
	
}
