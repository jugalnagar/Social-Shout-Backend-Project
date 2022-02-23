package com.Internity.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Internity.model.Comment;
import com.Internity.model.Likes;
import com.Internity.model.Post;
import com.Internity.model.User;
import com.Internity.repository.LikeRepository;
import com.Internity.repository.PostRepository;
import com.Internity.repository.UserRepository;

@Service
public class LikeService {

	@Autowired
	private LikeRepository likeRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Likes addLike(long postId,long mobile) {
		
		User user = userRepository.findByMobile(mobile);
		Post post = postRepository.findById(postId).get();
		if(post!=null && user!=null) {
			
			Likes like = new Likes();
			like.setPost(post);
			like.setUser(user);
			like.setLiketime(new Timestamp(System.currentTimeMillis()));
			return likeRepository.save(like);
		}			
		return null;
	}
	
	public List<Likes> getAllLikes(long postId) {
		Post post = postRepository.findById(postId).get();
		
		if(post!=null) {
			List<Likes> likes = likeRepository.findByPost(post);
			return likes;
		}			
		return null;
	}
}
