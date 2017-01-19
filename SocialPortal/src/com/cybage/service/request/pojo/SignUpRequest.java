package com.cybage.service.request.pojo;

import com.cybage.social.service.pojo.Login;
import com.cybage.social.service.pojo.User;

import flexjson.JSONDeserializer;

public class SignUpRequest {

	private Login loginDetails;
	private User userDetails;

	public Login getLoginDetails() {
		return loginDetails;
	}

	public void setLoginDetails(Login loginDetails) {
		this.loginDetails = loginDetails;
	}

	public User getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}

	public static SignUpRequest deserialise(String jsonUser) {
		JSONDeserializer<SignUpRequest> deserializer = new JSONDeserializer<SignUpRequest>();
		return deserializer.deserialize(jsonUser, SignUpRequest.class);
	}

}
