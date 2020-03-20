package com.backend.sport.services;

import java.util.List;

import com.backend.sport.models.Event;


/**
 * Service class for eventoDao class
 * 
 *
 */
public interface IEventService {

	/**
	 * Get event's list
	 * 
	 * @return event's list
	 */
	public List<Event> getAll();

	/**
	 * Get event by id
	 * 
	 * @param id
	 * @return event
	 */
	public Event getEventById(Integer id);

	/**
	 * Create new event
	 * 
	 * @param event
	 * @return event
	 */
	public Event newEvent(Event event);

	/**
	 * Delete event by id
	 * 
	 * @param id
	 * @return
	 */
	public Event delete(Integer id);
	
	/**
	 * Update event
	 * 
	 * @param event
	 * @return
	 */
	public Event update(Event event);
}
