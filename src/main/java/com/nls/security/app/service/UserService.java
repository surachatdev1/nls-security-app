package com.nls.security.app.service;


import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nls.security.app.model.User;

@Service
public class UserService {
	private static final String BASE_URL = "http://localhost:8080/security-service/users/";

	public List<User> getUsers() {
		String url = BASE_URL;
		RestTemplate restTemplate = new RestTemplate();
		User[] userArray = restTemplate.getForObject(url, User[].class);
		return Arrays.asList(userArray);
	}

	
	public User login(String username, String password) {
		String url = BASE_URL+"login";
		User userRequest = new User();
		userRequest.setUsername(username);
		userRequest.setPassword(password);
		
		//api connection
		RestTemplate restTemplate = new RestTemplate();
		userRequest = restTemplate.postForObject(url, userRequest, User.class);
		return userRequest;
	}




}
