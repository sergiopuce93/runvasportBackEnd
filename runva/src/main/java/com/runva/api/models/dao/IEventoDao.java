package com.runva.api.models.dao;

import java.util.List;

import com.runva.api.models.entity.Evento;

/**
 * Data access object for evento model
 * 
 * Manage all connections to runvasport data base about events
 * @author Sergio
 *
 */
public interface IEventoDao {

	/**
	 * Get all events
	 * 
	 * @return event's list
	 */
	List<Evento> getAll();

	/**
	 * Get event by id
	 * 
	 * @param id
	 * @return event
	 */
	Evento getEventById(Integer id);

	/**
	 * Create new event
	 * 
	 * @param event
	 * @return event
	 */
	Evento newEvent(Evento event);

	/**
	 * Delete event by id
	 * 
	 * @param id
	 */
	void delete(Integer id);
}
