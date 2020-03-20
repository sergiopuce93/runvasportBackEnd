package com.backend.sport.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.sport.models.Organizer;



/**
 * Implementation of organizerDao interface
 * 
 * Manage session and queries executions for runvasport data base
 * 
 *
 */
@Repository
public class OrganizerDaoImpl implements IOrganizerDao {

	@PersistenceContext
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.runva.api.models.dao.IOrganizerDao#getAll()
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Organizer> getAll() {
		List<Organizer> organizadores = em.createQuery("from Organizer").getResultList();
		return organizadores;
	}	

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.runva.api.models.dao.IOrganizerDao#getOrganizerById(java.lang.
	 * Integer)
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public Organizer getOrganizerById(Integer id) {

		List<Organizer> organizadores = em.createQuery("from Organizer e where e.id =:id").setParameter("id", id)
				.getResultList();

		if (!organizadores.isEmpty()) {
			return organizadores.get(0);
		} else {
			return new Organizer();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.runva.api.models.dao.IOrganizerDao#newOrganizer(com.runva.api.models.
	 * entity.Organizer)
	 */
	@Transactional
	@Override
	public Organizer newOrganizer(Organizer organizer) {
		em.persist(organizer);

		return organizer;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see com.runva.api.models.dao.IOrganizerDao#delete(java.lang.Integer)
	 */
	@Transactional
	@Override
	public void delete(Integer id) {
		Organizer organizer = getOrganizerById(id);
		if (organizer.getId() == null) {
			organizer = null;
		}
		em.remove(getOrganizerById(id));
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.runva.api.models.dao.IOrganizerDao#update(com.runva.api.models.entity.Organizer, com.runva.api.models.entity.Organizer)
	 */
	@Override
	public void update(Organizer newOrganizer, Organizer originalOrganizer) {
		originalOrganizer.join(newOrganizer);
		
		em.merge(originalOrganizer);
	}

}