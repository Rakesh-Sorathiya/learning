package com.conferencebooking.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "conference_room")
public class ConferenceRoom {

	@Id
	@Column(name = "conference_room_id")
	private long conferenceRoomId;

	private String conferenceRoomName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id", nullable = false)
	private Location location;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "conf_room_facilities", joinColumns = { @JoinColumn(name = "conference_room_id", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "facility_id", nullable = false, updatable = false) })
	private List<Facility> facilities;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "conf_room_purpose", joinColumns = { @JoinColumn(name = "conference_room_id", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "pupose_id", nullable = false, updatable = false) })
	private List<Purpose> conferenceRoomPurpose;

	private int conferenceRoomCapacity;

	public long getConferenceRoomId() {
		return conferenceRoomId;
	}

	public void setConferenceRoomId(long conferenceRoomId) {
		this.conferenceRoomId = conferenceRoomId;
	}

	public String getConferenceRoomName() {
		return conferenceRoomName;
	}

	public void setConferenceRoomName(String conferenceRoomName) {
		this.conferenceRoomName = conferenceRoomName;
	}

	public List<Facility> getFacilities() {
		return facilities;
	}

	public void setFacilities(List<Facility> facilities) {
		this.facilities = facilities;
	}

	public List<Purpose> getConferenceRoomPurpose() {
		return conferenceRoomPurpose;
	}

	public void setConferenceRoomPurpose(List<Purpose> conferenceRoomPurpose) {
		this.conferenceRoomPurpose = conferenceRoomPurpose;
	}

	public int getConferenceRoomCapacity() {
		return conferenceRoomCapacity;
	}

	public void setConferenceRoomCapacity(int conferenceRoomCapacity) {
		this.conferenceRoomCapacity = conferenceRoomCapacity;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
