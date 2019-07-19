package com.runvasport.springboot.backend.apirest.daos;

import java.util.List;

import com.runvasport.springboot.backend.apirest.models.Organizer;

public interface IOrganizerDao {

	List<Organizer> getAll();
}
