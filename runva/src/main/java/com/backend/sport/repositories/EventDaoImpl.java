package com.backend.sport.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.sport.models.Event;



/**
 * Implementation of eventoDao interface
 * 
 * Manage session and queries executions for runvasport data base
 * 
 *
 */
@Repository
public class EventDaoImpl implements IEventDao {

	@PersistenceContext
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.runva.api.models.dao.IEventDao#getAll()
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Event> getAll() {
		List<Event> events = em.createQuery("from Event").getResultList();
		return events;
	}

	/*
	 * (non-Javadoc) Get event by id
	 * 
	 * @see com.runva.api.models.dao.IEventDao#getEventById(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public Event getEventById(Integer id) {

		List<Event> events = em.createQuery("from Event e where e.id =:id").setParameter("id", id).getResultList();

		if (!events.isEmpty()) {
			return events.get(0);
		} else {
			return new Event();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.runva.api.models.dao.IEventDao#newEvent(com.runva.api.models.entity.
	 * Event)
	 */
	@Transactional
	@Override
	public Event newEvent(Event event) {
		em.persist(event);
		
		return event;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.runva.api.models.dao.IEventDao#delete(java.lang.Integer)
	 */
	@Transactional
	@Override
	public void delete(Integer id) {
		Event event = getEventById(id);
		if (event.getId() == null) {
			event = null;
		}
		em.remove(getEventById(id));
	}

	/*
	 * (non-Javadoc)
	 * @see com.runva.api.models.dao.IEventDao#update(com.runva.api.models.entity.Event, com.runva.api.models.entity.Event)
	 */
	@Override
	public void update(Event newEvent, Event originalEvent) {
		originalEvent.join(newEvent);
		
		em.merge(originalEvent);
	}

}
