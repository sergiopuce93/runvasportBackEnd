package com.runva.api.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.runva.api.models.dao.IEventoDao;
import com.runva.api.models.entity.Evento;

@Service
@Transactional
public class EventoServiceImpl implements IEventoService{

	@Autowired
	private IEventoDao eventoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Evento> getAll() {
		
		return eventoDao.getAll();
	}

	@Override
	public Evento getEventById(Integer id) {
		
		return eventoDao.getEventById(id);
	}

	@Override
	public Evento newEvent(Evento event) {
		
		return eventoDao.newEvent(event);
	}

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
