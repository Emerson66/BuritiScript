package com.buriti.codeblog.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.buriti.codeblog.model.Post;
import com.buriti.codeblog.model.service.CodeBlogService;

@Controller
public class CodeBlogController {
	@Autowired
	CodeBlogService codeBlogService;
	
	@GetMapping
	public String redirectToPosts() {
		return "redirect:/posts";
	}
	
	@GetMapping(value = "/posts")
	public ModelAndView  getPost() {
		ModelAndView mv = new ModelAndView("posts");
		List<Post> posts = codeBlogService.findAll();
		mv.addObject("posts", posts);
		
		return mv;
	}
	
	@GetMapping(value = "/posts/{id}")
	public ModelAndView getPostDetails(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("postDetails");
		Post post = codeBlogService.findById(id);
		mv.addObject("post",post);
		
		return mv;
	}
	
	@GetMapping(value = "/newPost")
	public ModelAndView getPostForm(){
		ModelAndView mv = new ModelAndView("postForm");
		mv.addObject(new Post());
		return mv;
	}
	
	@PostMapping(value = "newPost")
	public ModelAndView savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes,
			RedirectAttributes redirect) {
		post.setData(LocalDate.now());
		ModelAndView mv = new ModelAndView("postForm");
		mv.addObject(post);
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
			return mv;
		}
		
		codeBlogService.save(post);
		mv.setViewName("redirect:/posts");
		return mv;
	}
	
	
}
