package com.buriti.buritiscript.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.buriti.buritiscript.domain.model.Post;
import com.buriti.buritiscript.domain.service.PostService;
@Controller
@RequestMapping("/")
public class PostController {
	private static String caminhoImg = "/home/emreson/Imagens/buritiScript/img/";

	@Autowired
	PostService postService;

	@GetMapping
	public String redirectToPosts() {
		return "redirect:/posts";

	}

	@GetMapping(value = "/posts")
	public ModelAndView getPosts() {
		ModelAndView mv = new ModelAndView("posts");
		List<Post> posts = postService.findAll();
		mv.addObject("posts", posts);
		mv.setStatus(HttpStatus.OK);
		return mv;
	}

	@GetMapping(value = "/posts/{id}")
	public ModelAndView getPostDetails(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("postDetails");
		Post post = postService.findById(id);
		mv.addObject("post", post);

		return mv;
	}

	@GetMapping(value = "/posts/novo")
	public ModelAndView novoPost() {
		ModelAndView mv = new ModelAndView("postForm");
		mv.addObject(new Post());
		return mv;
	}

	@PostMapping(value = "/posts")
	public ModelAndView salvar(@Valid Post post, BindingResult result,
			RedirectAttributes attributes,RedirectAttributes redirect,
			@RequestParam("imagem") MultipartFile imagem) {

		post.setData(LocalDate.now());
		ModelAndView mv = new ModelAndView("postForm");

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
			return mv;
		}
		mv.addObject(post);

		postService.save(post);
		try {
			if (!imagem.isEmpty()) {
				byte[] bytes = imagem.getBytes();
				Path caminho = Paths.get(caminhoImg + String.valueOf(post.getId()) + imagem.getOriginalFilename());
				Files.write(caminho, bytes);

				post.setNomeImagem(String.valueOf(post.getId()) + imagem.getOriginalFilename());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		postService.save(post);
		mv.setViewName("redirect:/posts");
		return mv;
	}
	 
	@GetMapping("/posts/mostrarImagem/{imagem}")
	@ResponseBody
	public byte[] retornarImagem(@PathVariable("imagem") String imagem) throws IOException {
		File imagemArquivo = new File(caminhoImg +imagem);
		if(imagem!=null || imagem.trim().length()>0) {
		
			return Files.readAllBytes(imagemArquivo.toPath());
		
		}
		return null;
	}
	
	@GetMapping("/posts/novo/{id}")
	public ModelAndView editar(@PathVariable("id") Post post) {
		ModelAndView mv = new ModelAndView("postForm");
		mv.addObject(post);
		
		return mv;
	}
}
