package com.conferencebooking.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import flexjson.JSONSerializer;

@Table(name = "locations")
@Entity
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "location_id")
	private long locationId;

	@Column(name = "location")
	private String location;

	@ElementCollection
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "location")
	private List<ConferenceRoom> conferenceRoomList;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public List<ConferenceRoom> getConferenceRoomList() {
		return conferenceRoomList;
	}

	public void setConferenceRoomList(List<ConferenceRoom> conferenceRoomList) {
		this.conferenceRoomList = conferenceRoomList;
	}

	public static String serialise(List<Location> locationList) {

		JSONSerializer jsonSerializer = new JSONSerializer();
		jsonSerializer.exclude("class");
		String locationListJsonObject = jsonSerializer.serialize(locationList);
		return locationListJsonObject;
	}

	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", location=" + location
				+ ", conferenceRoomList=" + conferenceRoomList + "]";
	}
	
	
}
