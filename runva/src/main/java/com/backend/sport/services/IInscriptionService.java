package com.backend.sport.services;

import java.util.List;

import com.backend.sport.models.Inscription;




/**
 * Service class for inscriptionoDao class
 * 
 *
 */
public interface IInscriptionService {

	/**
	 * Get inscription's list
	 * 
	 * @return inscription's list
	 */
	public List<Inscription> getAll();

	/**
	 * Get inscription by id
	 * 
	 * @param id
	 * @return inscription
	 */
	public Inscription getInscriptionById(Integer id);

	/**
	 * Create new inscription
	 * 
	 * @param inscription
	 * @return inscription
	 */
	public Inscription newInscription(Inscription inscription);

	/**
	 * Delete inscription by id
	 * 
	 * @param id
	 * @return
	 */
	public Inscription delete(Integer id);
	
	/**
	 * Update inscription
	 * 
	 * @param inscription
	 * @return
	 */
	public Inscription update(Inscription inscription);
}
