package com.buriti.buritiscript.configuration;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.buriti.buritiscript.domain.model.Role;

public class ImplementsUserDetails implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	private String login;
	private String senha;
//	private Collection<? extends GrantedAuthority> authorities;
	private List<Role> roles;
 
	
	
	
	public ImplementsUserDetails(String login, String senha, List<Role> roles) {
		super();
		this.login = login;
		this.senha = senha;
//		this.authorities = roles.stream().map(x -> new SimpleGrantedAuthority(x.getNomeRole())).collect(Collectors.toList());
		this.roles = roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return roles;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
