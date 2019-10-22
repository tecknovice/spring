package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/login")
	public String login() {
		return "bootstrap-login-form";
	}
	@GetMapping("/access-denied")
	public String accessDenied() {
		return "access-denied";
	}
}
