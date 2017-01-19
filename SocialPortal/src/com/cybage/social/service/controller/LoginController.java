package com.cybage.social.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.social.service.pojo.Login;

@RestController
public class LoginController {

	@Autowired
	UserValidator validator;

	@RequestMapping(path = "/login", method = RequestMethod.GET, consumes = "apllication/json", produces = "application/json")
	public String login(String loginRequest) {
		Login login = Login.deserialise(loginRequest);
		if (validator.validateUser(login)) {
			return "SUCCESS";
		}
		return "FAILED";

	}
}
