package com.Internity.controller;



import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Internity.component.FileUploadHelper;
import com.Internity.model.Story;
import com.Internity.model.User;
import com.Internity.service.StoryService;
import com.Internity.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/stroy")
public class StoryController {

	@Autowired
	private StoryService storyService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FileUploadHelper fileUploadHelper;
	
	@ApiOperation(value = "Upload new Story of Existing user")
	@PostMapping(path="/{mobile}")
	public ResponseEntity<Object> createNewStory(@RequestBody Story story,@PathVariable("mobile") long mobile) {
		
		
		User userFetch = null;
		try {
			userFetch = userService.findByMobile(mobile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			story.setUser(userFetch);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Post Photo path is not correct");
		}
		
		try {
			story = storyService.addStroy(story);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Post Uploadation Failed!!!!!!");
		}
		
		return ResponseEntity.ok(story);
	}
	
	@ApiOperation(value = "Get all story Of Existing User")
	@GetMapping("/{mobile}") 
	public ResponseEntity<Object> fetchAllStoryOfUser(@PathVariable("mobile")long mobile){
		
		User userFetch = null;
		try{
			userFetch = userService.findByMobile(mobile);
		}catch (Exception e) {
			throw new NoSuchElementException("User Not Exist");
		}
		
		
		List<Story> stories = null;
		
		try {
			stories = storyService.getStroy(userFetch);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Post not exist for particular user");
		}
		
		return ResponseEntity.ok(stories);
	}
	
	
	
	
}
