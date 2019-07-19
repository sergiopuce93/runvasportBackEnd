package com.runva.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/api")
public class EventoController {

	/**
	 * 
	 * Event service
	 */
	@Autowired
	private IEventoService eventoService;

	/**
	 * 
	 * Error messages
	 */
	private static final String MISSINGDATA = "MISSING DATA";
	private static final String EVENTDOESNTEXIST = "EVENT DOESN'T EXIST";
	private static final String EVENTEXIST = "EVENT EXIST";
	private static final String BADREQUEST = "BAD REQUEST";
	private static final String BDERROR = "DATA BASE ERROR";

	/**
	 * 
	 * Get all events
	 */
	@GetMapping("/eventos")
	public ResponseEntity<List<Evento>> getEvents() {
		return ResponseEntity.ok().body(eventoService.getAll());
	}

	/**
	 * 
	 * Get a event by id
	 * 
	 * @param event's id
	 * @return event
	 */
	@GetMapping("/eventos/{idEvent}")
	public ResponseEntity<?> getEventById(@PathVariable("idEvent") Integer idEvent) {
		Evento evento = null;
		Map<String, Object> response = new HashMap<>();

		try {
			evento = eventoService.getEventById((idEvent));
		} catch (DataAccessException e) {
			response.put("mensaje", BDERROR);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (evento.getId() == null) {
			response.put("error", EVENTDOESNTEXIST);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Evento>(evento, HttpStatus.OK);
	}
	
	/**
	 * 
	 * Add new event
	 * 
	 * @param new event
	 */
	@PostMapping("/")
	public ResponseEntity<?> newEvent(@RequestBody Evento event) {
		
		
		return null;
	}
}
