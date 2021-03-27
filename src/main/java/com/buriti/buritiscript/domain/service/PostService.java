package com.buriti.buritiscript.domain.service;

import java.util.List;

import com.buriti.buritiscript.domain.model.Post;

public interface PostService {
	
	List<Post> findAll();
	Post findById(long id);
	Post save(Post post);
}
