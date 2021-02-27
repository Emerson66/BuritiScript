package com.buriti.codeblog.model.service;

import java.util.List;

import com.buriti.codeblog.model.Post;

public interface CodeBlogService {
	
	List<Post> findAll();
	Post findById(long id);
	Post save(Post post);
}
