package com.buriti.buritiscript.domain.service.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.buriti.buritiscript.domain.model.Usuario;
import com.buriti.buritiscript.domain.repository.UsuarioRepository;
import com.buriti.buritiscript.domain.service.UsuarioService;

@Service
public class UsuarioServiceImplement implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder; 
	
	
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
		criptografaSenha(usuario);
		return usuarioRepository.save(usuario);
	}

	@Override
	public void criptografaSenha(Usuario usuario) {
		usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
//		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
	}

	@Override
	public void relacionaRoleAoUsuario(String role) {
		 
	}

	

}
