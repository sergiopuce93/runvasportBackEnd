package com.backend.sport.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.sport.models.Inscription;
import com.backend.sport.repositories.IInscriptionDao;


/**
 * Implementation of Service for inscriptionDao
 * 
 *
 */
@Service
@Transactional
public class InscriptionServiceImpl implements IInscriptionService{

	/*
	 * Inscription data access object
	 */
	@Autowired
	private IInscriptionDao inscriptionDao;
	
	/*
	 * (non-Javadoc)
	 * @see com.runva.api.models.service.IInscripcionService#getAll()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Inscription> getAll() {
		
		return inscriptionDao.getAll();
	}

	/*
	 * (non-Javadoc)
	 * @see com.runva.api.models.service.IInscripcionService#getInscriptionById(java.lang.Integer)
	 */
	@Override
	public Inscription getInscriptionById(Integer id) {
		
		return inscriptionDao.getInscriptionById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.runva.api.models.service.IInscripcionService#newInscription(com.runva.api.models.entity.Inscription)
	 */
	@Override
	public Inscription newInscription(Inscription inscrption) {
		
		return inscriptionDao.newInscription(inscrption);
	}

	/*
	 * (non-Javadoc)
	 * @see com.runva.api.models.service.IInscripcionService#delete(java.lang.Integer)
	 */
	@Override
	public Inscription delete(Integer id) {
		
		Inscription inscriptionExist = inscriptionDao.getInscriptionById(id);
		
		if(inscriptionExist.getId() == null) {
			return null;
		}
		
		inscriptionDao.delete(id);
		return inscriptionDao.getInscriptionById(id);
	}
	
	/*
	 *  (non-Javadoc)
	 *  @see com.runva.api.models.service.IInscripcionService#update(com.runva.api.models.
	 * 	entity.Event))
	 */
	@Override
	public Inscription update(Inscription inscription) {

		Inscription inscriptionExist = inscriptionDao.getInscriptionById(inscription.getId());

		if (inscriptionExist.getId() == null) {
			return null;
		}

		inscriptionDao.update(inscription, inscriptionExist);
		return inscriptionDao.getInscriptionById(inscription.getId());
	}

}
