package com.cybage.social.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.service.request.pojo.SignUpRequest;
import com.cybage.social.service.dao.UserDaoImpl;
import com.cybage.social.service.pojo.Login;
import com.cybage.social.service.pojo.User;

@RestController
public class SignUpController {

	private final String SIGN_UP_URL = "/signUp";

	@Autowired
	UserDaoImpl userDao;

	@RequestMapping(path = SIGN_UP_URL, method = RequestMethod.POST, consumes = "application/json")
	public String signUp(@RequestBody String signUpRequestJson) {

		SignUpRequest signUpRequest = SignUpRequest
				.deserialise(signUpRequestJson);

		User user = signUpRequest.getUserDetails();
		Login login = signUpRequest.getLoginDetails();
		userDao.saveUser(user);
		userDao.saveLogin(login);

		return "SUCCESS";
	}

}
