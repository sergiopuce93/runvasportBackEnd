package com.runva.api.controllers;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.runva.api.models.entity.Evento;
import com.runva.api.models.service.IEventoService;

/**
 * Controller class Event class
 * 
 * HTTP mappings
 * 
 * @authoR SERGIO
 */
@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/eventos")
public class EventoController {

	/**
	 * Event service
	 */
	@Autowired
	private IEventoService eventoService;

	/* 
	 * Response default messages
	 */
	private static final String EVENTDOESNTEXIST = "EVENT DOESN'T EXIST";
	private static final String BADREQUEST = "BAD REQUEST";
	private static final String EVENTDELETE = "EVENT DELETE";
	private static final String EVENTCREATE = "EVENT CREATED";

	/**
	 * Get all events
	 */
	@GetMapping("/")
	public ResponseEntity<List<Evento>> getEvents() {
		return ResponseEntity.ok().body(eventoService.getAll());
	}

	/**
	 * Get a event by id
	 * 
	 * @param event's id
	 * @return event
	 */
	@GetMapping("/{idEvent}")
	public ResponseEntity<?> getEventById(@PathVariable("idEvent") Integer idEvent) {
		Evento evento = null;
		Map<String, Object> response = new HashMap<>();

		try {
			evento = eventoService.getEventById(idEvent);
		} catch (DataAccessException e) {
			response.put("mensaje", BADREQUEST);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (evento.getId() == null) {
			response.put("mensaje", EVENTDOESNTEXIST);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Evento>(evento, HttpStatus.OK);
	}

	/**
	 * Add new event
	 * 
	 * @param new event
	 */
	@PostMapping("/")
	public ResponseEntity<?> newEvent(@Valid @RequestBody Evento event, BindingResult result) {
		Evento eventoNew = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			eventoNew = eventoService.newEvent(event);
		} catch (DataAccessException e) {
			response.put("mensaje", BADREQUEST);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("message", EVENTCREATE);
		response.put("evento", eventoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	/**
	 * Delete event by id
	 * 
	 * @param idEvent
	 * @return
	 */
	@DeleteMapping("/{idEvent}")
	public ResponseEntity<?> delete(@PathVariable Integer idEvent) {
		Evento evento = null;
		Map<String, Object> response = new HashMap<>();

		try {
			evento = eventoService.getEventById(idEvent);
		} catch (DataAccessException e) {
			response.put("message", BADREQUEST);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (evento.getId() == null) {
			response.put("message", EVENTDOESNTEXIST);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		eventoService.delete(idEvent);
		response.put("message", EVENTDELETE);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
