package com.runva.api.models.service;

import java.util.List;

import com.runva.api.models.entity.User;

/**
 * Service class for userDao class
 * 
 * @author Sergio
 *
 */
public interface IUserService {

	/**
	 * Get user's list
	 * 
	 * @return user's list
	 */
	public List<User> getAll();

	/**
	 * Get user by id
	 * 
	 * @param id
	 * @return user
	 */
	public User getUserById(Integer id);

	/**
	 * Create new user
	 * 
	 * @param user
	 * @return user
	 */
	public User newUser(User user);

	/**
	 * Delete user by id
	 * 
	 * @param id
	 * @return
	 */
	public User delete(Integer id);

	/**
	 * Update user
	 * 
	 * @param user
	 * @return
	 */
	public User update(User user);
}
