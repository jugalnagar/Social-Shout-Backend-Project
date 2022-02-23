package com.Internity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Internity.model.Comment;
import com.Internity.model.Likes;
import com.Internity.service.LikeService;

@RestController
@RequestMapping("/like")
public class LikeController {
	
	@Autowired
	private LikeService likeService;
	
	@PostMapping("/{mobile}/{postId}")
	public ResponseEntity<Object> addComment(@PathVariable("postId") long postId,@PathVariable("mobile") long mobile) {
		
		Likes savedLike = likeService.addLike(postId,mobile);
		
		if(savedLike==null) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.accepted().body(savedLike);
	}
	
	@GetMapping("/{postId}")
	public ResponseEntity<Object> getLikes(@PathVariable("postId") long postId) {
		
		List<Likes> likes = likeService.getAllLikes(postId);
		
		if(likes==null) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.accepted().body(likes);
	}
}
