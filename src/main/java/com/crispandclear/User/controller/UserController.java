package com.crispandclear.User.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crispandclear.User.entity.User;
import com.crispandclear.User.service.UserService;
import com.crispandclear.User.vo.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/users")
@Slf4j
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping(value = "/add")
	public User saveUser(@RequestBody User user) {
		log.info("recieved requst to add a user having values :" + user);
		return service.saveUser(user);

	}

	@GetMapping(value = "/getbyid/{id}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
		log.info("recieved requst to get user having UserId :" + userId);
		return service.getUserWithDepartment(userId);

	}

}
