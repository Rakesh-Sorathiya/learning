package com.cybage.social.service.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cybage.social.service.pojo.FamilyMember;
import com.cybage.social.service.pojo.Login;
import com.cybage.social.service.pojo.User;

public class UserDaoImpl implements UserDao, FamilyMemberDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean saveUser(User user) {
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(user);
			tx.commit();

		} finally {
			session.close();
		}
		return true;
	}

	public boolean saveLogin(Login login) {
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(login);
			tx.commit();

		} finally {
			session.close();
		}
		return true;
	}

	@Override
	public boolean updateUserFamilyMember(FamilyMember familyMember) {

		Session session = sessionFactory.openSession();
		try {
			Query query = session
					.createQuery("update FamilyMember set member_name= :name, member_age= :age , "
							+ "member_releation=:relation  where member_id= :id");

			query.setParameter("name", familyMember.getMemberName());
			query.setParameter("age", familyMember.getMemberAge());
			query.setParameter("relation", familyMember.getRelation().name());
			query.setInteger("id", 1);

			int result = query.executeUpdate();

			return result == 0 ? true : false;

		} finally {
			session.close();
		}
	}

	@Override
	public void saveFamilyMember(String userId, FamilyMember familyMember) {

		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Query query = session
					.createSQLQuery("INSERT INTO familymember (member_age,member_name,member_releation,user_id)  VALUES"
							+ "(:age,:name,:relation,:userid)");

			query.setParameter("name", familyMember.getMemberName());
			query.setParameter("relation", familyMember.getRelation().name());
			query.setParameter("age", familyMember.getMemberAge());
			query.setString("userid", userId);
			query.executeUpdate();
			tx.commit();

		} finally {
			session.close();

		}

	}

	@Override
	public List<FamilyMember> fetchFamilyMember(String userId) {

		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Query query = session
					.createQuery("from FamilyMember where user_id=:id");
			query.setString("id", userId);
			List<FamilyMember> familyMemberList = query.list();
			tx.commit();
			return familyMemberList;
		} finally {
			session.close();

		}

	}

	public List<String> getPass(String userId) {
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Query query = session
					.createQuery("Select password from Login where user_id=:name");
			query.setString("name", userId);
			List<String >password = query.list();
			tx.commit();
			return password;
		} finally {
			session.close();

		}
	}

}
