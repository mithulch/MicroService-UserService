package com.crispandclear.User.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.crispandclear.User.entity.User;
import com.crispandclear.User.repository.UserRepository;
import com.crispandclear.User.vo.Department;
import com.crispandclear.User.vo.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RestTemplate template;

	public User saveUser(User user) {
		log.info("Inside user service class to add the user. ");
		return userRepo.save(user);

	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {

		ResponseTemplateVO vo = new ResponseTemplateVO();
		log.info("Inside user service class to get the department information");
		User user = userRepo.findByUserId(userId);

		Department dept = template.getForObject("http://DEPARTMENT-SERVICE/departments/getbyid/" + user.getDepartmentId(),
				Department.class);

		vo.setUser(user);
		vo.setDepartment(dept);
		return vo;

	}

}
