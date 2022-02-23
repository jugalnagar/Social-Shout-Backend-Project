package com.Internity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Internity.model.Likes;
import com.Internity.model.Post;

@Repository
public interface LikeRepository extends JpaRepository<Likes, Long> {

	public List<Likes> findByPost(Post post);
}
