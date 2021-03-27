package com.buriti.buritiscript.domain.service.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buriti.buritiscript.domain.model.Usuario;
import com.buriti.buritiscript.domain.repository.UsuarioRepository;
import com.buriti.buritiscript.domain.service.UsuarioService;

@Service
public class UsuarioServiceImplement implements UsuarioService{
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioRepository.findAll();
	}

	@Override
	public Usuario findById(String login) {
		return usuarioRepository.findByLogin(login);
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

}
