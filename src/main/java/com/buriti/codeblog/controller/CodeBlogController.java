package com.buriti.codeblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.buriti.codeblog.model.Post;
import com.buriti.codeblog.model.service.CodeBlogService;

@Controller
public class CodeBlogController {
	@Autowired
	CodeBlogService codeBlogService;
	
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
}
