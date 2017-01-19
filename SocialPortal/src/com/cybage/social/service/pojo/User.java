package com.cybage.social.service.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import flexjson.JSONDeserializer;

@Entity
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = { "user_id" }) })
public class User {

	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;

	@Id
	@Column(name = "user_id", unique = true, nullable = false)
	private String userId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_age")
	private int userAge;

	@OneToMany(mappedBy = "user")
	private List<FamilyMember> familyMembersList;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public List<FamilyMember> getFamilyMembersList() {
		return familyMembersList;
	}

	public void setFamilyMembersList(List<FamilyMember> familyMembersList) {
		this.familyMembersList = familyMembersList;
	}

	public static User deserialise(String jsonUser) {
		JSONDeserializer<User> userDeserialier = new JSONDeserializer<User>();
		return userDeserialier.deserialize(jsonUser, User.class);
	}

}
