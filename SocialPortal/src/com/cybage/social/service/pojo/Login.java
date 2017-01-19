package com.cybage.social.service.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import flexjson.JSONDeserializer;

@Table(name = "login", uniqueConstraints = { @UniqueConstraint(columnNames = { "user_id" }) })
@Entity
public class Login {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;

	@Column(name = "user_id", unique = true ,nullable=false)
	private String userId;

	@Column(name = "password")
	private String password;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static Login deserialise(String json) {
		JSONDeserializer<Login> deserialier = new JSONDeserializer<Login>();
		return deserialier.deserialize(json, Login.class);
	}

}
