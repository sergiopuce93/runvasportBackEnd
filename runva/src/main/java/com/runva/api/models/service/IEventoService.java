package com.runva.api.models.service;

import java.util.List;

import com.runva.api.models.entity.Evento;

public interface IEventoService {

	public List<Evento> getAll();
	
	public Evento getEventById(Integer id);
	
	public Evento newEvent(Evento event);
	
	public Evento delete(Integer id);
}
