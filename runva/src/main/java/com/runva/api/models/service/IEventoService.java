package com.runva.api.models.service;

import java.util.List;

import com.runva.api.models.entity.Evento;

/**
 * Service class for eventoDao class
 * 
 * @author Sergio
 *
 */
public interface IEventoService {

	/**
	 * Get event's list
	 * 
	 * @return event's list
	 */
	public List<Evento> getAll();

	/**
	 * Get event by id
	 * 
	 * @param id
	 * @return event
	 */
	public Evento getEventById(Integer id);

	/**
	 * Create new event
	 * 
	 * @param event
	 * @return event
	 */
	public Evento newEvent(Evento event);

	/**
	 * Delete event by id
	 * 
	 * @param id
	 * @return
	 */
	public Evento delete(Integer id);
}
