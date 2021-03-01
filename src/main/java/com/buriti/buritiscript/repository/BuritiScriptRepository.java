package com.buriti.buritiscript.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.buriti.buritiscript.model.Post;
@Repository
public interface BuritiScriptRepository extends JpaRepository<Post, Long>{

}
