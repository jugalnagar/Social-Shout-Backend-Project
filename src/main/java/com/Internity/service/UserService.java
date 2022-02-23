package com.Internity.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Internity.model.User;
import com.Internity.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public User registerUser(User user) {
		return userRepository.save(user);
		
	}
	
	public User findUserByMobile(long mobile) {
		return userRepository.findById(mobile).get();
		
	}
	
	public User loginUser(String email,String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}
	
	public User findByMobile(long mobile) {
		return userRepository.findById(mobile).get();
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public User resetPassword(User user,long mobile) {
		return null;
	}
}
