package com.Internity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Internity.model.Comment;
import com.Internity.model.Post;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
	
	public List<Comment> findByPost(Post post);
}
