package com.buriti.buritiscript.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.buriti.buritiscript.domain.model.Post;
@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}
