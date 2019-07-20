package com.runva.api.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.runva.api.models.dao.IInscriptionDao;
import com.runva.api.models.entity.Inscription;

/**
 * Implementation of Service for eventoDao
 * 
 * @author Sergio
 *
 */
@Service
@Transactional
public class InscriptionServiceImpl implements IInscriptionService{

	/*
	 * Inscription data access object
	 */
	@Autowired
	private IInscriptionDao eventoDao;
	
	/*
	 * (non-Javadoc)
	 * @see com.runva.api.models.service.IInscripcionService#getAll()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Inscription> getAll() {
		
		return eventoDao.getAll();
	}

	/*
	 * (non-Javadoc)
	 * @see com.runva.api.models.service.IInscripcionService#getInscriptionById(java.lang.Integer)
	 */
	@Override
	public Inscription getInscriptionById(Integer id) {
		
		return eventoDao.getInscriptionById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.runva.api.models.service.IInscripcionService#newInscription(com.runva.api.models.entity.Inscription)
	 */
	@Override
	public Inscription newInscription(Inscription inscrption) {
		
		return eventoDao.newInscription(inscrption);
	}

	/*
	 * (non-Javadoc)
	 * @see com.runva.api.models.service.IInscripcionService#delete(java.lang.Integer)
	 */
	@Override
	public Inscription delete(Integer id) {
		
		Inscription eventExist = eventoDao.getInscriptionById(id);
		
		if(eventExist.getId() == null) {
			return null;
		}
		
		eventoDao.delete(id);
		return eventoDao.getInscriptionById(id);
	}
	

}
