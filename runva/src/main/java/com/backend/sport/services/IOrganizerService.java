package com.backend.sport.services;

import java.util.List;

import com.backend.sport.models.Organizer;



/**
 * Service class for organizerDao class
 * 
 *
 */

public interface IOrganizerService {

	/**
	 * Get organizer's list
	 * 
	 * @return organizer's list
	 */
	public List<Organizer> getAll();

	/**
	 * Get organizer by id
	 * 
	 * @param id
	 * @return organizer
	 */
	public Organizer getOrganizerById(Integer id);

	/**
	 * Create new organizer
	 * 
	 * @param organizer
	 * @return organizer
	 */
	public Organizer newOrganizer(Organizer organizer);

	/**
	 * Delete organizer by id
	 * 
	 * @param id
	 * @return
	 */
	public Organizer delete(Integer id);
	
	/**
	 * Update organizer
	 * 
	 * @param organizer
	 * @return
	 */
	public Organizer update(Organizer organizer);
}