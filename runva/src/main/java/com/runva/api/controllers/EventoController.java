package com.runva.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.runva.api.models.entity.Evento;
import com.runva.api.models.service.IEventoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class EventoController {

	@Autowired
	private IEventoService eventoService;

	@GetMapping("/eventos")
	public ResponseEntity<List<Evento>> getEvents() {
		return ResponseEntity.ok().body(eventoService.getAll());
	}
}
