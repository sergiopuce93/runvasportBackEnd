package com.runvasport.springboot.backend.apirest.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.runvasport.springboot.backend.apirest.models.Organizer;

public class OrganizerDaoImpl implements IOrganizerDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Organizer> getAll() {
		
		List<Organizer> organizers = sessionFactory.getCurrentSession().createQuery("from serviciosorganizadores").list();
		return organizers;
	}

}
