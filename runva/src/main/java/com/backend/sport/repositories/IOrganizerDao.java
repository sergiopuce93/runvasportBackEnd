package com.backend.sport.repositories;

import java.util.List;

import com.backend.sport.models.Organizer;



/**
 * Data access object for organizer model
 * 
 * Manage all connections to runvasport data base about organizers
 * 
 *
 */
public interface IOrganizerDao {

	/**
	 * Get all organizers
	 * 
	 * @return organizer's list
	 */
	List<Organizer> getAll();

	/**
	 * Get organizer by id
	 * 
	 * @param id
	 * @return organizer
	 */
	Organizer getOrganizerById(Integer id);

	/**
	 * Create new organizer
	 * 
	 * @param organizer
	 * @return organizer
	 */
	Organizer newOrganizer(Organizer organizer);

	/**
	 * Delete organizer by id
	 * 
	 * @param id
	 */
	void delete(Integer id);
	
	/**
	 * Update organizer
	 * 
	 * @param organizer
	 */
	void update(Organizer newOrganizer, Organizer originalOrganizer);
}