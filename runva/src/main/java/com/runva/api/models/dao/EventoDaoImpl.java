package com.runva.api.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.runva.api.models.entity.Evento;

@Repository
public class EventoDaoImpl implements IEventoDao{

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Evento> getAll() {
		return em.createQuery("from Evento").getResultList();
	}
	
	
}
