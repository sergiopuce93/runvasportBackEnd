package com.runva.api.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.runva.api.models.entity.User;

@Repository
public class UserDaoImpl implements IUserDao{

	@PersistenceContext
	private EntityManager em;
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.runva.api.models.dao.IUserDao#getAll()
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<User> getAll() {
		List<User> users = em.createQuery("from User").getResultList();
		return users;
	}

	/*
	 * (non-Javadoc) Get user by id
	 * 
	 * @see com.runva.api.models.dao.IUserDao#getUserById(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public User getUserById(Integer id) {

		List<User> users = em.createQuery("from User e where e.id =:id").setParameter("id", id).getResultList();

		if (!users.isEmpty()) {
			return users.get(0);
		} else {
			return new User();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.runva.api.models.dao.IUserDao#newUser(com.runva.api.models.entity.
	 * User)
	 */
	@Transactional
	@Override
	public User newUser(User user) {
		em.persist(user);
		
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.runva.api.models.dao.IUserDao#delete(java.lang.Integer)
	 */
	@Transactional
	@Override
	public void delete(Integer id) {
		User user = getUserById(id);
		if (user.getId() == null) {
			user = null;
		}
		em.remove(getUserById(id));
	}

	/*
	 * (non-Javadoc)
	 * @see com.runva.api.models.dao.IUserDao#update(com.runva.api.models.entity.User, com.runva.api.models.entity.User)
	 */
	@Override
	public void update(User newUser, User originalUser) {
		originalUser.join(newUser);
		
		em.merge(originalUser);
	}

	
}
