package com.bolsadeideas.springboot.error.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.error.app.models.domain.User;

@Service
public class UserServiceImplements implements UserService {

	private List<User> list;
	
	public UserServiceImplements() {
		this.list = new ArrayList<>();
		this.list.add(new User(1,"Leo","Gonzalez"));
		this.list.add(new User(2,"Mario","Casas"));
		this.list.add(new User(3,"Luis","Salinas"));
		this.list.add(new User(4,"Damian","Gorriti"));
		this.list.add(new User(5,"Fabio","Dominguez"));
		this.list.add(new User(6,"Florencia","Lara"));
		this.list.add(new User(7,"Aaron","Ruth"));
		this.list.add(new User(8,"Sabrina","Heinserberg"));
		this.list.add(new User(9,"Barbara","Jimenez"));
		this.list.add(new User(10,"Marisol","Agüada"));
	}
	
	@Override
	public List<User> doList() {
		return this.list;
	}

	@Override
	public User getById(Integer id) {
		User result = null;
		for (User user : this.list) {
			if(user.getId().equals(id)) {
				result = user;
				break;
			}
		}
		return result;
	}

	@Override
	public Optional<User> getByIdOptional(Integer id) {
		User user = this.getById(id);
		return Optional.ofNullable(user);
	}
}
