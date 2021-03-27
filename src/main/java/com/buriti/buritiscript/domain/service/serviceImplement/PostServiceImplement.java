package com.buriti.buritiscript.domain.service.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buriti.buritiscript.domain.model.Post;
import com.buriti.buritiscript.domain.repository.PostRepository;
import com.buriti.buritiscript.domain.service.PostService;



@Service
public class PostServiceImplement implements PostService{

	@Autowired
	PostRepository postRepository;
	
	@Override
	public List<Post> findAll() {
		// TODO Auto-generated method stub
		return postRepository.findAll();
	}

	@Override
	public Post findById(long id) {
		// TODO Auto-generated method stub
		return postRepository.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		// TODO Auto-generated method stub
		return postRepository.save(post);
	}

}
