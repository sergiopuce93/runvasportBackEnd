package com.runva.api.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

<<<<<<< Updated upstream
=======
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
>>>>>>> Stashed changes
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.runva.api.models.entity.Evento;

@Repository
<<<<<<< Updated upstream
public class EventoDaoImpl implements IEventoDao{

	@PersistenceContext
	private EntityManager em;
	
=======
@Transactional
public class EventoDaoImpl implements IEventoDao {

//	@PersistenceContext
//	private EntityManager em;
	@Autowired
//    private SessionFactory sessionFactory;

>>>>>>> Stashed changes
	/*
	 * (non-Javadoc)
	 * Get all events
	 * @see com.runva.api.models.dao.IEventoDao#getAll()
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Evento> getAll() {
		
//		sessionFactory.getCurrentSession().createQuery("from Evento").getResultList();
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * Get event by id
	 * @see com.runva.api.models.dao.IEventoDao#getEventById(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public Evento getEventById(Integer id) {
<<<<<<< Updated upstream
		List<Evento> eventos = em.createQuery("from Evento e where e.id =:id").setParameter("id", id).getResultList();
		return eventos.get(0);
=======
//		List<Evento> eventos = em.createQuery("from Evento e where e.id =:id").setParameter("id", id).getResultList();
//
//		if (!eventos.isEmpty()) {
//			return eventos.get(0);
//		} else {
//			return new Evento();
//		}
		return null;
>>>>>>> Stashed changes
	}
	
	
	
	
}
