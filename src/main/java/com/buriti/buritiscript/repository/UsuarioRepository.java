package com.buriti.buritiscript.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.buriti.buritiscript.model.Usuario;
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String>{
	Usuario findByLogin(String login);
}
