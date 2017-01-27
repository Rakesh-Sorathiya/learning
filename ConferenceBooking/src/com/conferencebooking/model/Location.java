package com.conferencebooking.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "location_id")
	private int locationId;

	@Column(name = "location")
	private String location;

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy = "location")
	private List<ConferenceRoom> conferenceRoomList;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public List<ConferenceRoom> getConferenceRoomList() {
		return conferenceRoomList;
	}

	public void setConferenceRoomList(List<ConferenceRoom> conferenceRoomList) {
		this.conferenceRoomList = conferenceRoomList;
	}

}
