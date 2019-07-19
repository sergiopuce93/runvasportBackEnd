package com.runva.api.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.runva.api.models.entity.Evento;

@Repository
public class EventoDaoImpl implements IEventoDao {

	@PersistenceContext
	private EntityManager em;
	

	/*
	 * (non-Javadoc) Get all events
	 * 
	 * @see com.runva.api.models.dao.IEventoDao#getAll()
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Evento> getAll() {
		List<Evento> eventos = em.createQuery("from Evento").getResultList();
		return eventos;
	}

	/*
	 * (non-Javadoc) Get event by id
	 * 
	 * @see com.runva.api.models.dao.IEventoDao#getEventById(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public Evento getEventById(Integer id) {

		List<Evento> eventos = em.createQuery("from Evento e where e.id =:id").setParameter("id", id).getResultList();

		if (!eventos.isEmpty()) {
			return eventos.get(0);
		} else {
			return new Evento();
		}
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.runva.api.models.dao.IEventoDao#newEvent(com.runva.api.models.entity.Evento)
	 */
	@Transactional
	@Override
	public Evento newEvent(Evento event) {
		
		em.persist(event);
		return event;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.runva.api.models.dao.IEventoDao#delete(java.lang.Integer)
	 */
	@Transactional
	@Override
	public void delete(Integer id) {
		Evento event = getEventById(id);
		if(event.getId() == null) {
			
		}
		em.remove(getEventById(id));
	}
	

}
