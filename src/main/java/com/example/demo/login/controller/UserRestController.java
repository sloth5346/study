package com.example.demo.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.model.User;
import com.example.demo.domain.service.RestService;

@RestController
public class UserRestController {
	
	@Autowired
	RestService service;
	
	@GetMapping("/rest/get")
	public List<User> getUserMany(){
		return service.selectMany();
	}
	
	@GetMapping("/rest/get/{id:.+}")
	public User getUserOne(@PathVariable("id")String userId) {
		return service.selectOne(userId);
	}

}
