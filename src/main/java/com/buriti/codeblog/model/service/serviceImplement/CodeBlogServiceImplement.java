package com.buriti.codeblog.model.service.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buriti.codeblog.model.Post;
import com.buriti.codeblog.model.service.CodeBlogService;
import com.buriti.codeblog.repository.CodeBlogRepository;
@Service
public class CodeBlogServiceImplement implements CodeBlogService{

	@Autowired
	CodeBlogRepository codeBlogRepository;
	
	@Override
	public List<Post> findAll() {
		// TODO Auto-generated method stub
		return codeBlogRepository.findAll();
	}

	@Override
	public Post findById(long id) {
		// TODO Auto-generated method stub
		return codeBlogRepository.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		// TODO Auto-generated method stub
		return codeBlogRepository.save(post);
	}

}
