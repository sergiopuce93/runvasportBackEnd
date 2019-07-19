package com.runvasport.springboot.backend.apirest.services;

import java.util.List;
import com.runvasport.springboot.backend.apirest.models.Organizer;

public interface IOrganizerService {

	List<Organizer> getAll();
}
