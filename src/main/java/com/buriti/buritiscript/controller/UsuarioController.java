package com.buriti.buritiscript.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.buriti.buritiscript.domain.model.Usuario;
import com.buriti.buritiscript.domain.model.enums.Sexo;
import com.buriti.buritiscript.domain.service.UsuarioService;

@Controller
@RequestMapping("usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/novo")
	public ModelAndView novoUsuario(Usuario usuario) {	
		ModelAndView mv = new ModelAndView("userForm");
		mv.addObject(usuario);
		return mv;
	}
	
	@PostMapping
	public ModelAndView salvar(@Validated Usuario usuario) {
		
      
		ModelAndView mv = new ModelAndView("loginForm");
		mv.addObject(usuario);
		usuarioService.save(usuario);
		return mv;
	}
	
	@ModelAttribute("sexo")
	public List<Sexo> sexos(){
		return Arrays.asList(Sexo.values());
	}
}
