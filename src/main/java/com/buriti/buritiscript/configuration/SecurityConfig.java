package com.buriti.buritiscript.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsService userDetailsService;
//	@Autowired
//	JWTUtil jwtUtil;
	
	
	private static final String[] PUBLIC_MATCHERS_GET = {
			"/",
			"/posts",
			"/posts/{codigo}",
			"/usuarios",
			"/usuarios/novo",
			"/login",
			"/posts/mostrarImagem/{imagem}"
			
			
	};
	private static final String[] IGNORE_LIST = {
			"/css/**",
			"/js/**"
	};
	
	private static final String[] PUBLIC_MATCHERS_POST = {
			"/usuarios",
			"/login"
	};
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable();
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
			.antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST).permitAll()
			.anyRequest().authenticated()
			.and().formLogin().permitAll()
			.and().formLogin().loginPage("/login")
			.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		
//		http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil));
//		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
//		return source;
//	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Override 
//	public void configure(AuthenticationManagerBuilder auth) throws Exception{
//		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
//	}
	
	@Override 
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers(IGNORE_LIST);
	}
}
