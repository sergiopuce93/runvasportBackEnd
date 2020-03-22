package com.backend.sport.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.backend.sport.models.Event;
import com.backend.sport.services.IEventService;


/**
 * Controller class Event class
 * 
 * HTTP mappings
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/events")
public class EventController {

	/**
	 * Event service
	 */
	@Autowired
	private IEventService eventService;

	/*
	 * Response default messages
	 */
	private static final String EVENTDOESNTEXIST = "NO EXISTE EL EVENTO ";
	private static final String BADREQUEST = "BAD REQUEST";
	private static final String EVENTDELETE = "EVENTO ELIMINADO";
	private static final String EVENTCREATE = "EVENTO CREADO";
	private static final String EVENTNOTVALID = "FORMATO NO VALIDO";
	private static final String EVENTUPDATED = "EVENTO ACTUALIZADO";

	/**
	 * Get all events
	 */
	@GetMapping("/")
	public ResponseEntity<List<Event>> getEvents() {
		return ResponseEntity.ok().body(eventService.getAll());
	}

	/**
	 * Get a event by id
	 * 
	 * @param event's id
	 * @return event
	 */
	@GetMapping("/{idEvent}")
	public ResponseEntity<?> getEventById(@PathVariable("idEvent") Integer idEvent) {
		Event event = null;
		Map<String, Object> response = new HashMap<>();

		try {
			event = eventService.getEventById(idEvent);
		} catch (DataAccessException e) {
			response.put("error", BADREQUEST);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (event.getId() == null) {
			response.put("error", EVENTDOESNTEXIST);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}

	@PostMapping("/fileUpload")
	public ResponseEntity<?> postFile(@Valid @RequestParam("file") MultipartFile file)  {
		Map<String, Object> response = new HashMap<>();
		if(!file.isEmpty()) {
			Path directoryResources = Paths.get("src//main//resources//static//uploads");
			String rootPath = directoryResources.toFile().getAbsolutePath();
			try {
				byte[] bytes = file.getBytes();
				Path route = Paths.get(rootPath + "//" + file.getOriginalFilename());
				Files.write(route, bytes);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.print(e.getMessage());
			}
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	/**
	 * Add new event
	 * 
	 * @param new event
	 */
	@PostMapping("/")
	public ResponseEntity<?> newEvent(@Valid @RequestBody Event event,BindingResult result) {
		Event eventoNew = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> err.getField().toUpperCase() + " " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		

		try {
			eventoNew = eventService.newEvent(event);
		} catch (DataAccessException e) {
			response.put("error", BADREQUEST);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", EVENTCREATE);
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
		Event event = null;
		Map<String, Object> response = new HashMap<>();

		try {
			event = eventService.getEventById(idEvent);
		} catch (DataAccessException e) {
			response.put("error", BADREQUEST);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (event.getId() == null) {
			response.put("error", EVENTDOESNTEXIST);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		eventService.delete(idEvent);
		response.put("mensaje", EVENTDELETE);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	/**
	 * Update event
	 */
	@PutMapping("/")
	public ResponseEntity<?> update(@Valid @RequestBody Event event, BindingResult result) {

		Map<String, Object> response = new HashMap<>();
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> err.getField().toUpperCase() + " " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (!isValid(event)) {
			response.put("error", EVENTNOTVALID);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		Event updatedEvent = eventService.update(event);
		
		response.put("mensaje", EVENTUPDATED);
		response.put("eventUpdated",updatedEvent);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	/**
	 * Valid event
	 * 
	 * @param event
	 * @return
	 */
	private boolean isValid(Event event) {
		if (event == null || event.getName() == null || "".equals(event.getName())) {
			return false;
		}
		return true;
	}
}
