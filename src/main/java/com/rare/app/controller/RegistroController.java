package com.rare.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistroController {

	@GetMapping({ "/", "/home" })
	public String verPaginaDeInicio() {
		return "home";
	}

	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
	}

	@GetMapping("/contact")
	public String contactar() {
		return "contact";
	}

}
