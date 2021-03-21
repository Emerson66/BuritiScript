package com.buriti.buritiscript.repository;

import org.springframework.data.repository.CrudRepository;

import com.buriti.buritiscript.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{
	Usuario findByLogin(String login);
}
