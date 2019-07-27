package com.runva.api.models.dao;

import java.util.List;

import com.runva.api.models.entity.Inscription;

/**
 * Data access object for inscription model
 * 
 * Manage all connections to runvasport data base about inscriptions
 * 
 * @author Sergio
 *
 */
public interface IInscriptionDao {

	/**
	 * Get all inscriptions
	 * 
	 * @return inscription's list
	 */
	List<Inscription> getAll();

	/**
	 * Get inscription by id
	 * 
	 * @param id
	 * @return inscription
	 */
	Inscription getInscriptionById(Integer id);

	/**
	 * Create new inscription
	 * 
	 * @param inscription
	 * @return inscription
	 */
	Inscription newInscription(Inscription inscription);

	/**
	 * Delete inscription by id
	 * 
	 * @param id
	 */
	void delete(Integer id);
	
	/**
	 * Update inscription
	 * 
	 * @param inscription
	 */
	void update(Inscription newInscription, Inscription originalInscription);
}
