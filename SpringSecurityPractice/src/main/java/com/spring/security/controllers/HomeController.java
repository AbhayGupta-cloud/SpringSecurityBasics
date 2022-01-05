package com.spring.security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class HomeController {
	@GetMapping("/home")
	public String home() {
		return "This is home page.";
	}
	@GetMapping("/login")
	public String login() {
		return "This Is Login Page";
	}
	@GetMapping("/register")
	public String register() {
		return "This is Register Page";
	}
}
