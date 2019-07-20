package com.runva.api.models.service;

import java.util.List;

import com.runva.api.models.entity.Event;

/**
 * Service class for eventoDao class
 * 
 * @author Sergio
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
}
