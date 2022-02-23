package com.Internity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Internity.model.Story;
import com.Internity.model.User;

@Repository
public interface StoryRepository extends JpaRepository<Story, Long>{
	
	public List<Story> findByUser(User user);
}
