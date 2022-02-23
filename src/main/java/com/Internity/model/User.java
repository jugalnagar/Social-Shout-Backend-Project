package com.Internity.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name = "users")
public class User {
	
	
	@Id
	@Max(value = 9999999999L ,message = "Enter 10 Digit mobile number")
	@Min(value = 1000000000,message = "Enter 10 Digit mobile number")
	private long mobile;
	
	
	@NotBlank(message = "First Name must enter")
	@Size(min = 2,max = 30,message = "Number of character must >2 and <30 ")
	private String fullName;
	
	@NotBlank(message = "username must enter")
	@Size(min = 5,max = 30,message = "Number of character must >5 and <30 ")
	private String userName;
	
	@Email
	@NotBlank(message="Gmail must required")
	private String email;
	
	
	@Size(min = 8,message = "Length of Password must greater than 8")
	@NotBlank(message = "Password must required")
	private String password;
	
	
	private String profile;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Post> posts;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Story> stories;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Likes> likes;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Comment> comments;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Follow> follows;
	
	
	
	public List<Follow> getFollows() {
		return follows;
	}
	public void setFollows(List<Follow> follows) {
		this.follows = follows;
	}
	public List<Story> getStories() {
		return stories;
	}
	public void setStories(List<Story> stories) {
		this.stories = stories;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String gmail) {
		this.email = gmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Likes> getLikes() {
		return likes;
	}
	public void setLikes(List<Likes> likes) {
		this.likes = likes;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
}
