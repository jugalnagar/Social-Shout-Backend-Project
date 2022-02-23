package com.Internity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Internity.model.Story;
import com.Internity.model.User;
import com.Internity.repository.StoryRepository;

@Service
public class StoryService {
	
	@Autowired
	private StoryRepository storyRepository;
	
	public Story addStroy(Story story) {
		Story savedStory = storyRepository.save(story);
		return savedStory;
	}
	
	public List<Story> getStroy(User user) {
		List<Story> fetchStory = storyRepository.findByUser(user);
		return fetchStory;
	}
	
	
	
	public long count() {
		return storyRepository.count();
	}
}
