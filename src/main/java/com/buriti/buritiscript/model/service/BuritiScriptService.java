package com.buriti.buritiscript.model.service;

import java.util.List;

import com.buriti.buritiscript.model.Post;

public interface BuritiScriptService {
	
	List<Post> findAll();
	Post findById(long id);
	Post save(Post post);
}
