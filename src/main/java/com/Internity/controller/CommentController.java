package com.Internity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Internity.model.Comment;
import com.Internity.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/{mobile}/{postId}")
	public ResponseEntity<Object> addComment(@RequestBody Comment comment,@PathVariable("postId") long postId,@PathVariable("mobile") long mobile) {
		
		Comment savedComment = commentService.addComment(postId,mobile, comment.getCommentContent());
		
		if(savedComment==null) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.accepted().body(savedComment);
	}
	
	@GetMapping("/{postId}")
	public ResponseEntity<Object> getComments(@PathVariable("postId") long postId) {
		
		List<Comment> comments = commentService.getAllComment(postId);
		
		if(comments==null) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(comments);
	}
}
