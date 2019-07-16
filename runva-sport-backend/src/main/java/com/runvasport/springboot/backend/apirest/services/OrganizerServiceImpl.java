package com.runvasport.springboot.backend.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.runvasport.springboot.backend.apirest.daos.IOrganizerDao;
import com.runvasport.springboot.backend.apirest.models.Organizer;


@Service
@Transactional
public class OrganizerServiceImpl implements IOrganizerService{

	@Autowired
	private IOrganizerDao iOrganizerDao;
	
	@Override
	public List<Organizer> getAll() { 
		return iOrganizerDao.getAll();
	}

}
