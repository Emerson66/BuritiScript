package com.buriti.buritiscript.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.buriti.buritiscript.domain.model.Usuario;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@GetMapping("/login")
	public ModelAndView irParaLogin(Usuario usuario) {
		ModelAndView mv = new ModelAndView("loginForm");
		return mv;
	}
}
