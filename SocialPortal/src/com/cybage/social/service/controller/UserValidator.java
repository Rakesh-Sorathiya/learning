package com.cybage.social.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cybage.social.service.dao.UserDaoImpl;
import com.cybage.social.service.pojo.Login;

public class UserValidator {

	@Autowired
	UserDaoImpl userDaoImpl;

	public boolean validateUser(Login login) {
		List<String> pass = userDaoImpl.getPass(login.getUserId());
		if (pass != null && login.getPassword().equalsIgnoreCase(pass.get(0))) {
			return true;
		}
		return false;

	}
}
