package com.rare.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rare.app.controller.dto.UsuarioRegistroDTO;
import com.rare.app.model.Usuario;
import com.rare.app.repository.UsuarioRepository;
import com.rare.app.service.UsuarioService;

@Controller
@RequestMapping("/signup")
public class RegistroUsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	private UsuarioService usuarioService;

	public RegistroUsuarioController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}

	@ModelAttribute("usuario")
	public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
		return new UsuarioRegistroDTO();
	}

	@GetMapping
	public String mostrarFormularioDeRegistro() {
		return "signup";
	}

	@PostMapping
	public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO) {
		Usuario usuarioExistente = usuarioRepository.findByEmail(registroDTO.getEmail());
		if (usuarioExistente != null) {
			return "redirect:/signup?error";
		}
		usuarioService.guardar(registroDTO);
		return "redirect:/signup?success";
	}

}
