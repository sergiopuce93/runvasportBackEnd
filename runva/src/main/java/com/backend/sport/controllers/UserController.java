package com.backend.sport.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.sport.models.User;
import com.backend.sport.services.IUserService;

/**
 * Controller class User class
 * 
 * HTTP mappings
 * 
 */
@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/users")
public class UserController {

	/**
	 * User service
	 */
	@Autowired
	private IUserService userService;

	/*
	 * Response default messages
	 */
	private static final String USERDOESNTEXIST = "USER DOESN'T EXIST";
	private static final String BADREQUEST = "BAD REQUEST";
	private static final String USERDELETE = "USER DELETE";
	private static final String USERCREATE = "USER CREATED";
	private static final String USERNOTVALID = "USER FORMAT NOT VALID";
	private static final String USERUPDATED = "USER UPDATED";

	/**
	 * Get all users
	 */
	@GetMapping("/")
	public ResponseEntity<List<User>> getUsers() {
		return ResponseEntity.ok().body(userService.getAll());
	}

	/**
	 * Get a user by id
	 * 
	 * @param user's id
	 * @return user
	 */
	@GetMapping("/{idUser}")
	public ResponseEntity<?> getUserById(@PathVariable("idUser") Integer idUser) {
		User user = null;
		Map<String, Object> response = new HashMap<>();

		try {
			user = userService.getUserById(idUser);
		} catch (DataAccessException e) {
			response.put("error", BADREQUEST);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (user.getId() == null) {
			response.put("error", USERDOESNTEXIST);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	/**
	 * Add new user
	 * 
	 * @param new user
	 */
	@PostMapping("/")
	public ResponseEntity<?> newUser(@Valid @RequestBody User user, BindingResult result) {
		User useroNew = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> "The field "+ err.getField() + " " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			useroNew = userService.newUser(user);
		} catch (DataAccessException e) {
			response.put("error", BADREQUEST);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("message", USERCREATE);
		response.put("user", useroNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	/**
	 * Delete user by id
	 * 
	 * @param idUser
	 * @return
	 */
	@DeleteMapping("/{idUser}")
	public ResponseEntity<?> delete(@PathVariable Integer idUser) {
		User user = null;
		Map<String, Object> response = new HashMap<>();

		try {
			user = userService.getUserById(idUser);
		} catch (DataAccessException e) {
			response.put("error", BADREQUEST);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (user.getId() == null) {
			response.put("error", USERDOESNTEXIST);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		userService.delete(idUser);
		response.put("message", USERDELETE);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	/**
	 * Update user
	 */
	@PutMapping("/")
	public ResponseEntity<?> update(@Valid @RequestBody User user, BindingResult result) {

		Map<String, Object> response = new HashMap<>();
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> "The field "+ err.getField() + " " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (!isValid(user)) {
			response.put("error", USERNOTVALID);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		User updatedUser = userService.update(user);
		
		response.put("message", USERUPDATED);
		response.put("UserUpdated", updatedUser);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	/**
	 * Valid user
	 * 
	 * @param user
	 * @return
	 */
	private boolean isValid(User user) {
		if (user == null || user.getName() == null || "".equals(user.getName())) {
			return false;
		}
		return true;
	}
}
