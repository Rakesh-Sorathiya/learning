package com.cybage.social.service.dao;

import java.util.List;

import com.cybage.social.service.pojo.FamilyMember;

public interface FamilyMemberDao {

	public boolean updateUserFamilyMember(FamilyMember familyMember);
	public void saveFamilyMember(String userId,FamilyMember familyMember);
	public List<FamilyMember> fetchFamilyMember(String userId);
}
