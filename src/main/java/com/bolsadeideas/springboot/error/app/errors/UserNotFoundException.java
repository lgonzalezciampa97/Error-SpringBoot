package com.bolsadeideas.springboot.error.app.errors;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String id) {
		
		super("User ID: ".concat(id).concat(" doesn´t exist in the system"));
	}

	private static final long serialVersionUID = 1L;
	
	

}
