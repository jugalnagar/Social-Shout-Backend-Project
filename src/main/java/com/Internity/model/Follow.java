package com.Internity.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Follow {
	
	@Id
	private long followId;
	
	@OneToOne
	private User follower;
	
	@OneToOne
	private User following;
	
	

	public long getFollowId() {
		return followId;
	}

	public void setFollowId(long followId) {
		this.followId = followId;
	}

	public User getFollower() {
		return follower;
	}

	public void setFollower(User follower) {
		this.follower = follower;
	}

	public User getFollowing() {
		return following;
	}

	public void setFollowing(User following) {
		this.following = following;
	}
	
	
}
