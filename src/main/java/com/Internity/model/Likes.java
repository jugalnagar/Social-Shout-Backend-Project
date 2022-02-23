package com.Internity.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Likes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long likeId;
	
	@JsonIgnore
	private Timestamp liketime;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Post post;

	@OneToOne(fetch = FetchType.LAZY)
	private User user;
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getLikeId() {
		return likeId;
	}

	public void setLikeId(long likeId) {
		this.likeId = likeId;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Timestamp getLiketime() {
		return liketime;
	}

	public void setLiketime(Timestamp liketime) {
		this.liketime = liketime;
	}

	
	
	
}
