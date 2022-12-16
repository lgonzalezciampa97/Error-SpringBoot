package com.bolsadeideas.springboot.error.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bolsadeideas.springboot.error.app.errors.UserNotFoundException;
import com.bolsadeideas.springboot.error.app.models.domain.User;
import com.bolsadeideas.springboot.error.app.services.UserService;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	private UserService userService;

	@SuppressWarnings("unused")
	@GetMapping("/index")
	public String index() {
//		Integer value = 100/0;
		Integer value = Integer.parseInt("10x");
		return "index";
	}

	@GetMapping("/see/{id}")
	public String see(@PathVariable Integer id, Model model) {
//		User user = userService.getById(id);

		User user = userService.getByIdOptional(id).orElseThrow(() -> new UserNotFoundException(id.toString()));

		if (user == null) {
			throw new UserNotFoundException(id.toString());
		}

		model.addAttribute("user", user);
		model.addAttribute("title", "User details: ".concat(user.getName()));
		return "see";
	}

}
