package com.buriti.buritiscript.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	ImplementsUserDetailsService implementsUserDetailsService;
	
	private static final String[] AUTH_LIST = {
			"/",
			"/posts",
			"/posts/{id}",
			"/posts/{id}",
			"/posts/mostrarImagem/{imagem}",
			
			"/usuarios",
			"/usuarios/novo",
			
			"/login"
	};
	private static final String[] IGNORE_LIST = {
			"/css/**",
			"/js/**"
	};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests()
		.antMatchers(AUTH_LIST).permitAll()
		.antMatchers(HttpMethod.GET, "/posts/novo").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.POST, "/posts").hasAnyRole("ADMIN")
		.anyRequest().authenticated()
		.and().formLogin().permitAll()
		.and().formLogin().loginPage("/login")
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(implementsUserDetailsService)
		.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override 
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers(IGNORE_LIST);
	}
}
