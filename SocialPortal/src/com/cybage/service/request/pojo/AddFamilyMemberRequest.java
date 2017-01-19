package com.cybage.service.request.pojo;

import com.cybage.social.service.pojo.FamilyMember;

import flexjson.JSONDeserializer;

public class AddFamilyMemberRequest {

	private String userId;
	private FamilyMember familyMember;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public FamilyMember getFamilyMember() {
		return familyMember;
	}

	public void setFamilyMember(FamilyMember familyMember) {
		this.familyMember = familyMember;
	}

	public static AddFamilyMemberRequest deserialise(String jsonUser) {
		JSONDeserializer<AddFamilyMemberRequest> deserializer = new JSONDeserializer<AddFamilyMemberRequest>();
		return deserializer.deserialize(jsonUser, AddFamilyMemberRequest.class);
	}

}
