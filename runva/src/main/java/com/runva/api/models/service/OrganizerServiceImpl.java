package com.runva.api.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.runva.api.models.dao.IOrganizerDao;
import com.runva.api.models.entity.Organizer;


/**
 * Implementation of Service for organizerDao
 * 
 *
 */
@Service
@Transactional
public class OrganizerServiceImpl implements IOrganizerService{

	/*
	 * Organizer data access object
	 */
	@Autowired
	private IOrganizerDao organizerDao;
	
	/*
	 * (non-Javadoc)
	 * @see com.runva.api.models.service.IOrganizerService#getAll()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Organizer> getAll() {
			
		return organizerDao.getAll();
	}

	/*
	 * (non-Javadoc)
	 * @see com.runva.api.models.service.IInscripcionService#getOrganizerById(java.lang.Integer)
	 */
	@Override
	public Organizer getOrganizerById(Integer id) {
		
		return organizerDao.getOrganizerById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.runva.api.models.service.IInscripcionService#newInscription(com.runva.api.models.entity.Organizer)
	 */
	@Override
	public Organizer newOrganizer(Organizer organizer) {
		
		return organizerDao.newOrganizer(organizer);
	}

	/*
	 * (non-Javadoc)
	 * @see com.runva.api.models.service.IOrganizerService#delete(java.lang.Integer)
	 */
	@Override
	public Organizer delete(Integer id) {
		
		Organizer organizerExist = organizerDao.getOrganizerById(id);
		
		if(organizerExist.getId() == null) {
			return null;
		}
		
		organizerDao.delete(id);
		return organizerDao.getOrganizerById(id);
	}
	
	/*
	 *  (non-Javadoc)
	 *  @see com.runva.api.models.service.IOrganizerService#update(com.runva.api.models.
	 * 	entity.Organizer))
	 */
	@Override
	public Organizer update(Organizer organizer) {

		Organizer organizerExist = organizerDao.getOrganizerById(organizer.getId());

		if (organizerExist.getId() == null) {
			return null;
		}

		organizerDao.update(organizer, organizerExist);
		return organizerDao.getOrganizerById(organizer.getId());
	}

}