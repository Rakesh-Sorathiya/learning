package com.cybage.social.service.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import flexjson.JSONDeserializer;

@Entity
@Table(name = "FamilyMember")
public class FamilyMember {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "member_id")
	private int memberId;

	@Column(name = "member_name")
	private String memberName;

	@Enumerated(EnumType.STRING)
	@Column(name = "member_releation")
	private Releation memberReleation;

	@Column(name = "member_age")
	private int memberAge;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Enumerated(EnumType.STRING)
	public Releation getRelation() {
		return memberReleation;
	}

	public void setRelation(Releation relation) {
		this.memberReleation = relation;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static FamilyMember deserialise(String json) {
		JSONDeserializer<FamilyMember> deserialier = new JSONDeserializer<FamilyMember>();
		return deserialier.deserialize(json, FamilyMember.class);
	}

}
