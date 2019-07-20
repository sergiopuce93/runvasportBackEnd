package com.runva.api.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.runva.api.models.entity.Inscription;

/**
 * Implementation of inscriptionoDao interface
 * 
 * Manage session and queries executions for runvasport data base
 * 
 * @author Sergio
 *
 */
@Repository
public class InscriptionDaoImpl implements IInscriptionDao {

	@PersistenceContext
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.runva.api.models.dao.IInscriptionDao#getAll()
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Inscription> getAll() {
		List<Inscription> inscripciones = em.createQuery("from Inscription").getResultList();
		return inscripciones;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.runva.api.models.dao.IInscriptionDao#getInscriptionById(java.lang.
	 * Integer)
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public Inscription getInscriptionById(Integer id) {

		List<Inscription> inscripciones = em.createQuery("from Inscription e where e.id =:id").setParameter("id", id)
				.getResultList();

		if (!inscripciones.isEmpty()) {
			return inscripciones.get(0);
		} else {
			return new Inscription();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.runva.api.models.dao.IInscriptionDao#newInscription(com.runva.api.models.
	 * entity.Inscription)
	 */
	@Transactional
	@Override
	public Inscription newInscription(Inscription inscription) {
		em.persist(inscription);

		return inscription;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.runva.api.models.dao.IInscriptionDao#delete(java.lang.Integer)
	 */
	@Transactional
	@Override
	public void delete(Integer id) {
		Inscription inscription = getInscriptionById(id);
		if (inscription.getId() == null) {
			inscription = null;
		}
		em.remove(getInscriptionById(id));
	}
}
