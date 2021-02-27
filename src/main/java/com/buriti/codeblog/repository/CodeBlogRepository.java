package com.buriti.codeblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.buriti.codeblog.model.Post;
@Repository
public interface CodeBlogRepository extends JpaRepository<Post, Long>{

}
