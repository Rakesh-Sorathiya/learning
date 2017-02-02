package com.conferencebooking.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import flexjson.JSONSerializer;

@Entity
@Table(name = "purpose")
public class Purpose {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "purpose_id")
	long purposeId;
	String purpose;

	public long getPurposeId() {
		return purposeId;
	}

	public void setPurposeId(long purposeId) {
		this.purposeId = purposeId;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public static String serialise(List<Purpose> purposeList) {
		JSONSerializer jsonSerializer = new JSONSerializer();
		jsonSerializer.exclude("class");
		return jsonSerializer.deepSerialize(purposeList);
	}

	@Override
	public String toString() {
		return "Purpose [purposeId=" + purposeId + ", purpose=" + purpose + "]";
	}
	
	

}
