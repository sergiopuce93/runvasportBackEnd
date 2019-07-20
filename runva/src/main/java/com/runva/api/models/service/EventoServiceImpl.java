package com.runva.api.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.runva.api.models.dao.IEventoDao;
import com.runva.api.models.entity.Evento;

/**
 * Implementation of Service for eventoDao
 * 
 * @author Sergio
 *
 */
@Service
@Transactional
public class EventoServiceImpl implements IEventoService{

	/*
	 * Evento data access object
	 */
	@Autowired
	private IEventoDao eventoDao;
	
	/*
	 * (non-Javadoc)
	 * @see com.runva.api.models.service.IEventoService#getAll()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Evento> getAll() {
		
		return eventoDao.getAll();
	}

	/*
	 * (non-Javadoc)
	 * @see com.runva.api.models.service.IEventoService#getEventById(java.lang.Integer)
	 */
	@Override
	public Evento getEventById(Integer id) {
		
		return eventoDao.getEventById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.runva.api.models.service.IEventoService#newEvent(com.runva.api.models.entity.Evento)
	 */
	@Override
	public Evento newEvent(Evento event) {
		
		return eventoDao.newEvent(event);
	}

	/*
	 * (non-Javadoc)
	 * @see com.runva.api.models.service.IEventoService#delete(java.lang.Integer)
	 */
	@Override
	public Evento delete(Integer id) {
		
		Evento eventExist = eventoDao.getEventById(id);
		
		if(eventExist.getId() == null) {
			return null;
		}
		
		eventoDao.delete(id);
		return eventoDao.getEventById(id);
	}
	

	
}
