package com.runva.api.models.dao;

import java.util.List;

import com.runva.api.models.entity.Evento;

public interface IEventoDao {

	/*
	 * Get all events
	 */
	List<Evento> getAll();

	/*
	 * Get event by id
	 * 
	 * @param id's event
	 */
	Evento getEventById(Integer id);
}
