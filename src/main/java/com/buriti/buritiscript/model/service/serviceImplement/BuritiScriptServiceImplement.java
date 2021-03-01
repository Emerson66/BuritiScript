package com.buriti.buritiscript.model.service.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buriti.buritiscript.model.Post;
import com.buriti.buritiscript.model.service.BuritiScriptService;
import com.buriti.buritiscript.repository.BuritiScriptRepository;
@Service
public class BuritiScriptServiceImplement implements BuritiScriptService{

	@Autowired
	BuritiScriptRepository buritiScriptRepository;
	
	@Override
	public List<Post> findAll() {
		// TODO Auto-generated method stub
		return buritiScriptRepository.findAll();
	}

	@Override
	public Post findById(long id) {
		// TODO Auto-generated method stub
		return buritiScriptRepository.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		// TODO Auto-generated method stub
		return buritiScriptRepository.save(post);
	}

}
