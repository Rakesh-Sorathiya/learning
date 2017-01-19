package com.cybage.service.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cybage.social.service.dao.UserDaoImpl;
import com.cybage.social.service.pojo.FamilyMember;
import com.cybage.social.service.pojo.Login;
import com.cybage.social.service.pojo.Releation;
import com.cybage.social.service.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:com/cybage/service/test/appServlet-servlet.xml", })
public class UserDaoImplTest {

	// DI
	@Autowired
	@Qualifier("userDao")
	UserDaoImpl userDao;

	@Test
	public void testSaveUser() {
		User user = new User();
		user.setUserName("Rakesh");
		user.setUserId("rakesh");
		user.setUserAge(25);
		Assert.assertTrue(userDao.saveUser(user));
	}

	@Test
	public void testSaveLogin() {
		Login login = new Login();
		login.setPassword("rakesh");
		login.setUserId("Rakesh");
		Assert.assertTrue(userDao.saveLogin(login));
	}

	@Test
	public void testSaveFamilyMember() {

		FamilyMember familyMember = new FamilyMember();
		familyMember.setMemberAge(25);
		familyMember.setMemberId(1);
		familyMember.setRelation(Releation.BROTHER);
		familyMember.setMemberName("Deep");

		userDao.saveFamilyMember("rakesh", familyMember);

	}

	@Test
	public void testUpdateUserFamilyMember() {

		FamilyMember familyMember = new FamilyMember();
		familyMember.setMemberAge(25);
		familyMember.setMemberId(1);
		familyMember.setRelation(Releation.BROTHER);
		familyMember.setMemberName("Darshan");
		userDao.updateUserFamilyMember(familyMember);
	}

	@Test
	public void testFetchFamilyMember() {
		List<FamilyMember> familyMembers = userDao.fetchFamilyMember("Rakesh");
		System.out.println("rakesh " + familyMembers.get(0).getMemberName());
	}

	@Test
	public void testgetPass() {
		System.out.println("password: " + userDao.getPass("Rakesh"));
	}

}
