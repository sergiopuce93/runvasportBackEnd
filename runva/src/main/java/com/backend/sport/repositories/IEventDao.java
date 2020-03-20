package com.backend.sport.repositories;

import java.util.List;

import com.backend.sport.models.Event;


/**
 * Data access object for evento model
 * 
 * Manage all connections to runvasport data base about events
 * 
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
	
	/**
	 * Update event
	 * 
	 * @param event
	 */
	void update(Event newEvent, Event originalEvent);
}
