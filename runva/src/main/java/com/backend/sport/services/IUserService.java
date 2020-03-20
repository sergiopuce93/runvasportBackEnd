package com.backend.sport.services;

import java.util.List;

import com.backend.sport.models.User;



/**
 * Service class for userDao class
 * 
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
