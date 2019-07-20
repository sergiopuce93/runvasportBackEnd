package com.runva.api.models.dao;

import java.util.List;

import com.runva.api.models.entity.Event;

/**
 * Data access object for evento model
 * 
 * Manage all connections to runvasport data base about events
 * 
 * @author Sergio
 *
 */
public interface IEventDao {

	/**
	 * Get all events
	 * 
	 * @return event's list
	 */
	List<Event> getAll();

	/**
	 * Get event by id
	 * 
	 * @param id
	 * @return event
	 */
	Event getEventById(Integer id);

	/**
	 * Create new event
	 * 
	 * @param event
	 * @return event
	 */
	Event newEvent(Event event);

	/**
	 * Delete event by id
	 * 
	 * @param id
	 */
	void delete(Integer id);
}
