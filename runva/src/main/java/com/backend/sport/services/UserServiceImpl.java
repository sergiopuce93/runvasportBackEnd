package com.backend.sport.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.sport.models.User;
import com.backend.sport.repositories.IUserDao;


/**
 * Implementation of Service for userDao
 * 
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {

	/*
	 * User data access object
	 */
	@Autowired
	private IUserDao userDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.runva.api.models.service.IUserService#getAll()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<User> getAll() {

		return userDao.getAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.runva.api.models.service.IUserService#getUserById(java.lang.Integer)
	 */
	@Override
	public User getUserById(Integer id) {

		return userDao.getUserById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.runva.api.models.service.IUserService#newUser(com.runva.api.models.
	 * entity.User)
	 */
	@Override
	public User newUser(User user) {

		return userDao.newUser(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.runva.api.models.service.IUserService#delete(java.lang.Integer)
	 */
	@Override
	public User delete(Integer id) {

		User userExist = userDao.getUserById(id);

		if (userExist.getId() == null) {
			return null;
		}

		userDao.delete(id);
		return userDao.getUserById(id);
	}

	@Override
	public User update(User user) {

		User userExist = userDao.getUserById(user.getId());

		if (userExist.getId() == null) {
			return null;
		}

		userDao.update(user, userExist);
		return userDao.getUserById(user.getId());
	}

}
