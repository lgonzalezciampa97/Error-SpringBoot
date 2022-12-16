package com.bolsadeideas.springboot.error.app.services;

import java.util.List;
import java.util.Optional;

import com.bolsadeideas.springboot.error.app.models.domain.User;

public interface UserService {
	
	public List<User> doList();
	public User getById(Integer id);
	public Optional<User> getByIdOptional(Integer id);

}
