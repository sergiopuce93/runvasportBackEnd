package com.runva.api.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.runva.api.models.entity.Evento;

@Repository
public class EventoDaoImpl implements IEventoDao{

	@PersistenceContext
	private EntityManager em;
	
	/*
	 * (non-Javadoc)
	 * Get all events
	 * @see com.runva.api.models.dao.IEventoDao#getAll()
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Evento> getAll() {
		return em.createQuery("from Evento").getResultList();
	}
	
	/*
	 * (non-Javadoc)
	 * Get event by id
	 * @see com.runva.api.models.dao.IEventoDao#getEventById(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public Evento getEventById(Integer id) {
		List<Evento> eventos = em.createQuery("from Evento e where e.id =:id").setParameter("id", id).getResultList();
		return eventos.get(0);
	}
	
	
	
	
}
