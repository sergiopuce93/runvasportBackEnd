package com.runva.api.models.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.runva.api.models.entity.Evento;

@Repository
public class EventoDaoImpl implements IEventoDao{

	
	@Transactional
	@Override
	public List<Evento> getAll() {
		return null;
	}
	
	
}
