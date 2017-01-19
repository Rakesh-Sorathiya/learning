package com.cybage.social.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.service.request.pojo.AddFamilyMemberRequest;
import com.cybage.social.service.dao.UserDaoImpl;
import com.cybage.social.service.pojo.FamilyMember;

@RestController
@RequestMapping("/family")
public class FamilyMemberController {

	private final String ADD_FAMILI_MEMEBER = "/add";
	private final String UPDATE_FAMILI_MEMEBER = "/update";
	@Autowired
	private UserDaoImpl userDao;

	@RequestMapping(path = ADD_FAMILI_MEMEBER, method = RequestMethod.POST, consumes = "application/json")
	public String addFamilyMember(@RequestBody String familyMember) {

		AddFamilyMemberRequest addFamilyMemberRequest = AddFamilyMemberRequest
				.deserialise(familyMember);

		String userId = addFamilyMemberRequest.getUserId();
		FamilyMember familyMemberObj = addFamilyMemberRequest.getFamilyMember();

		userDao.saveFamilyMember(userId, familyMemberObj);

		return "SUCCESS";
	}

	@RequestMapping(path = UPDATE_FAMILI_MEMEBER, method = RequestMethod.POST, consumes = "application/json")
	public String editFamilyMemeber(@RequestBody String familyMember) {

		FamilyMember familyMemberObj = FamilyMember.deserialise(familyMember);

		userDao.updateUserFamilyMember(familyMemberObj);

		return "SUCCESS";
	}
}
