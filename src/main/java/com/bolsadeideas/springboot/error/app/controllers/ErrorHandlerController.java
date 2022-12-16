package com.bolsadeideas.springboot.error.app.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bolsadeideas.springboot.error.app.errors.UserNotFoundException;

//use this annotation for and only for errors controllers
@ControllerAdvice
public class ErrorHandlerController {

	@ExceptionHandler(ArithmeticException.class)
	public String arithmeticError(ArithmeticException ex, Model model) {
		model.addAttribute("error","¡Arithmetic Error!");
		model.addAttribute("message",ex.getMessage());
		model.addAttribute("status",HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/arithmetic";
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public String numberFormatError(NumberFormatException ex, Model model) {
		model.addAttribute("error","¡Invalid number!");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status",HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/number_format";
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public String userNotFoundError(UserNotFoundException ex, Model model) {
		model.addAttribute("error","¡User not found!");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status",HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/user";
	}
	
}
