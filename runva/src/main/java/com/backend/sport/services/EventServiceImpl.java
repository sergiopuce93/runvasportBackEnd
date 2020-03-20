package com.backend.sport.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.sport.models.Event;
import com.backend.sport.repositories.IEventDao;


/**
 * Implementation of Service for eventDao
 * 
 *
 */
@Service
@Transactional
public class EventServiceImpl implements IEventService {

	/*
	 * Event data access object
	 */
	@Autowired
	private IEventDao eventDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.runva.api.models.service.IEventService#getAll()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Event> getAll() {

		return eventDao.getAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.runva.api.models.service.IEventService#getEventById(java.lang.Integer)
	 */
	@Override
	public Event getEventById(Integer id) {

		return eventDao.getEventById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.runva.api.models.service.IEventService#newEvent(com.runva.api.models.
	 * entity.Event)
	 */
	@Override
	public Event newEvent(Event event) {

		return eventDao.newEvent(event);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.runva.api.models.service.IEventService#delete(java.lang.Integer)
	 */
	@Override
	public Event delete(Integer id) {

		Event eventExist = eventDao.getEventById(id);

		if (eventExist.getId() == null) {
			return null;
		}

		eventDao.delete(id);
		return eventDao.getEventById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.runva.api.models.service.IEventService#update(om.runva.api.models.
	 * entity.Event)
	 */
	@Override
	public Event update(Event event) {

		Event eventExist = eventDao.getEventById(event.getId());

		if (eventExist.getId() == null) {
			return null;
		}

		eventDao.update(event, eventExist);
		return eventDao.getEventById(event.getId());
	}

}
