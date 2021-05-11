//package com.buriti.buritiscript.configuration;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Date;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import com.buriti.buritiscript.dto.CredenciaisDTO;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//
//	private AuthenticationManager authenticationManager;
//
//	private JWTUtil jwtUtil;
//
//	public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
//		setAuthenticationFailureHandler(new JWTAuthenticationFailureHandler());
//		this.authenticationManager = authenticationManager;
//		this.jwtUtil = jwtUtil;
//	}
//
//	@Override
//	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
//			throws AuthenticationException {
//		
//		try {
//			CredenciaisDTO credenciaisDTO = new ObjectMapper()
//					.readValue(request.getInputStream(), CredenciaisDTO.class);
//			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(credenciaisDTO.getLogin(), credenciaisDTO.getSenha(), new ArrayList<>());
//			
//			Authentication auth = authenticationManager.authenticate(authenticationToken);
//			
//			return auth;
//		}catch (IOException ex){
//			throw new RuntimeException(ex);
//		}
//	}
//
//	@Override
//	public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
//			Authentication auth) {
//
//		String username = ((ImplementsUserDetails) auth.getPrincipal()).getUsername();
//		String token = jwtUtil.generateToken(username);
//		response.addHeader("Authorization", "Bearer" + token);
//	}
//	
//	private class JWTAuthenticationFailureHandler implements AuthenticationFailureHandler {
//
//		@Override
//		public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
//				AuthenticationException exception) throws IOException, ServletException {
//			response.setStatus(401);
//			response.setContentType("Application/json");
//			response.getWriter().append(json());
//		}
//		
//		private String json() {
//			long date = new Date().getTime();
//			return "{\"timestamp\": "+ date + ", "
//						+"\"status\": 401, "
//						+"\"error\": \"Não autorizado\", "
//						+"\"message\": \"Email ou senha inválidos\", "
//						+"\"path\": \"/login\"}";
//			
//		}
//	}
//}
