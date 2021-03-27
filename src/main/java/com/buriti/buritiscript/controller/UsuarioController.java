package com.buriti.buritiscript.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.buriti.buritiscript.domain.model.Usuario;

@Controller
@RequestMapping("usuarios")
public class UsuarioController {
	
	
	
	@GetMapping("/novo")
	public ModelAndView novoUsuario(Usuario usuario) {	
		ModelAndView mv = new ModelAndView("userForm");
		mv.addObject(usuario);
		return mv;
	}
	
	@PostMapping
	public ModelAndView salvar(Usuario usuario) {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject(usuario);
		
		return mv;
	}
}
