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

import com.backend.sport.models.Organizer;
import com.backend.sport.services.IOrganizerService;


/**
 * Controller class Organizer class
 * 
 * HTTP mappings
 * 
 */
@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/organizers")
public class OrganizersController {

	/**
	 * Organizer service
	 */
	@Autowired
	private IOrganizerService organizerService;

	/*
	 * Response default messages
	 */
	private static final String ORGANIZERDOESNTEXIST = "ORGANIZER DOESN'T EXIST";
	private static final String BADREQUEST = "BAD REQUEST";
	private static final String ORGANIZERDELETE = "ORGANIZER DELETE";
	private static final String ORGANIZERCREATE = "ORGANIZER CREATED";
	private static final String ORGANIZERNOTVALID = "ORGANIZER FORMAT NOT VALID";
	private static final String ORGANIZERUPDATED = "ORGANIZER FORMAT NOT VALID";

	/**
	 * Get all organizers
	 */
	@GetMapping("/")
	public ResponseEntity<List<Organizer>> getOrganizers() {
		return ResponseEntity.ok().body(organizerService.getAll());
	}

	/**
	 * Get a organizer by id
	 * 
	 * @param organizer's id
	 * @return organizer
	 */
	@GetMapping("/{idOrganizer}")
	public ResponseEntity<?> getOrganizerById(@PathVariable("idOrganizer") Integer idOrganizer) {
		Organizer organizer = null;
		Map<String, Object> response = new HashMap<>();

		try {
			organizer = organizerService.getOrganizerById(idOrganizer);
		} catch (DataAccessException e) {
			response.put("error", BADREQUEST);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (organizer.getId() == null) {
			response.put("error", ORGANIZERDOESNTEXIST);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Organizer>(organizer, HttpStatus.OK);
	}

	/**
	 * Add new organizer
	 * 
	 * @param new organizer
	 */
	@PostMapping("/")
	public ResponseEntity<?> newOrganizer(@Valid @RequestBody Organizer organizer, BindingResult result) {
		Organizer organizernoNew = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "The field " + err.getField() + " " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			organizernoNew = organizerService.newOrganizer(organizer);
		} catch (DataAccessException e) {
			response.put("error", BADREQUEST);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("error", ORGANIZERCREATE);
		response.put("organizer", organizernoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	/**
	 * Delete organizer by id
	 * 
	 * @param idOrganizer
	 * @return
	 */
	@DeleteMapping("/{idOrganizer}")
	public ResponseEntity<?> delete(@PathVariable Integer idOrganizer) {
		Organizer organizer = null;
		Map<String, Object> response = new HashMap<>();

		try {
			organizer = organizerService.getOrganizerById(idOrganizer);
		} catch (DataAccessException e) {
			response.put("error", BADREQUEST);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (organizer.getId() == null) {
			response.put("error", ORGANIZERDOESNTEXIST);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		organizerService.delete(idOrganizer);
		response.put("message", ORGANIZERDELETE);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	/**
	 * Update organizer
	 */
	@PutMapping("/")
	public ResponseEntity<?> update(@Valid @RequestBody Organizer organizer, BindingResult result) {

		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "The field " + err.getField() + " " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (!isValid(organizer)) {
			response.put("error", ORGANIZERNOTVALID);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		Organizer updatedOrganizer = organizerService.update(organizer);

		response.put("message", ORGANIZERUPDATED);
		response.put("eventUpdated", updatedOrganizer);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	/**
	 * Valid organizer
	 * 
	 * @param organizer
	 * @return
	 */
	private boolean isValid(Organizer organizer) {

		if (organizer == null || organizer.getId() == null) {
			return false;
		}
		return true;

	}

}	