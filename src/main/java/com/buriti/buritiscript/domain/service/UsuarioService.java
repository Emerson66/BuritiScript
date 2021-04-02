package com.buriti.buritiscript.domain.service;

import java.util.List;

import com.buriti.buritiscript.domain.model.Usuario;

public interface UsuarioService{
	List<Usuario> findAll();
	Usuario findById(String login);
	Usuario save(Usuario usuario0);
	void criptografaSenha(Usuario usuario);
	void relacionaRoleAoUsuario(String role);
}
