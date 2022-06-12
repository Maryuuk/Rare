package com.rare.app.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.rare.app.controller.dto.UsuarioRegistroDTO;
import com.rare.app.model.Usuario;

public interface UsuarioService extends UserDetailsService {

	public Usuario guardar(UsuarioRegistroDTO registroDTO);

}
