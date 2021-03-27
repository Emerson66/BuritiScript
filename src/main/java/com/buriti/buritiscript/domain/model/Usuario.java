package com.buriti.buritiscript.domain.model;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.buriti.buritiscript.domain.model.enums.Sexo;

@Entity
public class Usuario implements UserDetails{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String login;
	private String nome;
	private String pseudonimo;
	private String email;
	private String senha;
	private Sexo sexo;
	private LocalDate dataNscimento;
	
	public Usuario() {
		super();
	 }
	
	public Usuario(String login, String nome, String pseudonimo, String email, String senha, Sexo sexo,
			LocalDate dataNscimento) {
		super();
		this.login = login;
		this.nome = nome;
		this.pseudonimo = pseudonimo;
		this.email = email;
		this.senha = senha;
		this.sexo = sexo;
		this.dataNscimento = dataNscimento;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPseudonimo() {
		return pseudonimo;
	}

	public void setPseudonimo(String pseudonimo) {
		this.pseudonimo = pseudonimo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public LocalDate getDataNscimento() {
		return dataNscimento;
	}

	public void setDataNscimento(LocalDate dataNscimento) {
		this.dataNscimento = dataNscimento;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senha;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.login;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
