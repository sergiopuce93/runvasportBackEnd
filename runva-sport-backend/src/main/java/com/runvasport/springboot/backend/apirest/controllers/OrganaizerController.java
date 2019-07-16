package com.runvasport.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.runvasport.springboot.backend.apirest.models.Organizer;
import com.runvasport.springboot.backend.apirest.services.IOrganizerService;

@RestController
@RequestMapping("/organizadores")
public class OrganaizerController {
	
	@Autowired
	private IOrganizerService iOrganizerService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Organizer>> getOrganizadoresList() {
		return ResponseEntity.ok().body(iOrganizerService.getAll());
	}
}
