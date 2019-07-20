package com.runva.api.models.service;

import java.util.List;

import com.runva.api.models.entity.Inscription;

/**
 * Service class for inscriptionoDao class
 * 
 * @author Sergio
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
}
