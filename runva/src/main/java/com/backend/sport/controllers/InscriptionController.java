package com.backend.sport.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.sport.models.Inscription;
import com.backend.sport.services.IInscriptionService;


/**
 * Controller class Inscription class
 * 
 * HTTP mappings
 * 
 */
@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/inscriptions")
public class InscriptionController {

	/**
	 * Inscription service
	 */
	@Autowired
	private IInscriptionService inscriptionService;

	/*
	 * Response default messages
	 */
	private static final String INSCRIPTIONDOESNTEXIST = "INSCRIPTION DOESN'T EXIST";
	private static final String BADREQUEST = "BAD REQUEST";
	private static final String INSCRIPTIONDELETE = "INSCRIPTION DELETE";
	private static final String INSCRIPTIONCREATE = "INSCRIPTION CREATED";
	private static final String INSCRIPTIONNOTVALID = "INSCRIPTION FORMAT NOT VALID";
	private static final String INSCRIPTIONUPDATED = "INSCRIPTION UPDATED";

	/**
	 * Get all inscriptions
	 */
	@GetMapping("/")
	public ResponseEntity<List<Inscription>> getInscriptions() {
		return ResponseEntity.ok().body(inscriptionService.getAll());
	}

	/**
	 * Get a inscription by id
	 * 
	 * @param inscription's id
	 * @return inscription
	 */
	@GetMapping("/{idInscription}")
	public ResponseEntity<?> getInscriptionById(@PathVariable("idInscription") Integer idInscription) {
		Inscription inscription = null;
		Map<String, Object> response = new HashMap<>();

		try {
			inscription = inscriptionService.getInscriptionById(idInscription);
		} catch (DataAccessException e) {
			response.put("error", BADREQUEST);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (inscription.getId() == null) {
			response.put("error", INSCRIPTIONDOESNTEXIST);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Inscription>(inscription, HttpStatus.OK);
	}

	/**
	 * Add new inscription
	 * 
	 * @param new inscription
	 */
	@PostMapping("/")
	public ResponseEntity<?> newInscription(@Valid @RequestBody Inscription inscription, BindingResult result) {
		Inscription inscriptionoNew = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "The field " + err.getField() + " " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			inscriptionoNew = inscriptionService.newInscription(inscription);
		} catch (DataAccessException e) {
			response.put("error", BADREQUEST);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("error", INSCRIPTIONCREATE);
		response.put("inscription", inscriptionoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	/**
	 * Delete inscription by id
	 * 
	 * @param idInscription
	 * @return
	 */
	@DeleteMapping("/{idInscription}")
	public ResponseEntity<?> delete(@PathVariable Integer idInscription) {
		Inscription inscription = null;
		Map<String, Object> response = new HashMap<>();

		try {
			inscription = inscriptionService.getInscriptionById(idInscription);
		} catch (DataAccessException e) {
			response.put("error", BADREQUEST);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (inscription.getId() == null) {
			response.put("error", INSCRIPTIONDOESNTEXIST);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		inscriptionService.delete(idInscription);
		response.put("message", INSCRIPTIONDELETE);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	/**
	 * Update inscription
	 */
	@PutMapping("/")
	public ResponseEntity<?> update(@Valid @RequestBody Inscription inscription, BindingResult result) {

		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "The field " + err.getField() + " " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (!isValid(inscription)) {
			response.put("error", INSCRIPTIONNOTVALID);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		Inscription updatedInscription = inscriptionService.update(inscription);

		response.put("message", INSCRIPTIONUPDATED);
		response.put("eventUpdated", updatedInscription);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	/**
	 * Valid inscription
	 * 
	 * @param inscription
	 * @return
	 */
	private boolean isValid(Inscription inscription) {

		if (inscription == null || inscription.getId() == null) {
			return false;
		}
		return true;

	}

}
