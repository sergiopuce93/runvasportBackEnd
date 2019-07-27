package com.runva.api.models.dao;

import java.util.List;

import com.runva.api.models.entity.User;

public interface IUserDao {

	/**
	 * Get all users
	 * 
	 * @return user's list
	 */
	List<User> getAll();

	/**
	 * Get user by id
	 * 
	 * @param id
	 * @return user
	 */
	User getUserById(Integer id);

	/**
	 * Create new user
	 * 
	 * @param user
	 * @return user
	 */
	User newUser(User user);

	/**
	 * Delete user by id
	 * 
	 * @param id
	 */
	void delete(Integer id);
	
	/**
	 * Update user
	 * 
	 * @param user
	 */
	void update(User newUser, User originalUser);
}
