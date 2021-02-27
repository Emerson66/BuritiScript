package com.buriti.codeblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buriti.codeblog.model.Post;

public interface CodeBlogRepository extends JpaRepository<Post, Long>{

}
