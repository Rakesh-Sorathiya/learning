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
@Table(name = "facilities")
public class Facility {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "facility_id")
	private long facilityId;

	private String facility;

	public long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(long facilityId) {
		this.facilityId = facilityId;
	}

	public String getFacility() {
		return facility;
	}

	public void setFacility(String facility) {
		this.facility = facility;
	}

	public static String serialise(List<Facility> facilityList) {

		JSONSerializer jsonSerializer = new JSONSerializer();
		jsonSerializer.exclude("class");
		return jsonSerializer.deepSerialize(facilityList);
		
	}

}
