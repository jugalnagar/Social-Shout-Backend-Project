package com.Internity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Internity.model.Comment;
import com.Internity.model.Post;
import com.Internity.model.User;
import com.Internity.repository.CommentRepository;
import com.Internity.repository.PostRepository;
import com.Internity.repository.UserRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Comment addComment(long postId,long mobile,String commentContent) {
		User user = userRepository.findByMobile(mobile);
		Post post = postRepository.findById(postId).get();
		
		if(post!=null && user!=null) {
			
			Comment comment = new Comment();
			comment.setPost(post);
			comment.setUser(user);
			comment.setCommentContent(commentContent);
			
			return commentRepository.save(comment);
		}			
		return null;
	}
	
	public List<Comment> getAllComment(long postId) {
		Post post = postRepository.findById(postId).get();
		
		if(post!=null) {
			List<Comment> comments = commentRepository.findByPost(post);
			return comments;
		}			
		return null;
	}
}
