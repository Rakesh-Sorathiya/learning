package com.conferencebooking.db.services;

import java.util.List;

import com.conferencebooking.model.ConferenceRoom;
import com.conferencebooking.model.Facility;
import com.conferencebooking.model.Location;
import com.conferencebooking.model.Purpose;

public interface ConferenceBookingService {

	public void saveConfernceRoom(ConferenceRoom conferenceRoom);

	public List<ConferenceRoom> fetchConfernceRoom(
			ConferenceRoom conferenceRoomSearchInput);

	public ConferenceRoom fetchConferenceRoom(long conferenceRoomId);

	public void saveLocation(Location location);

	public void saveFacility(Facility facility);

	public void savePurpose(Purpose purposes);

	public Location fetchLocation(int locationId);

	public List<Location> fetchAllLocation();

	public Purpose fetchPurpose(int locationId);

	public List<Purpose> fetchAllPurpose();

	public Facility fetchFacility(int facilityId);

	public List<Facility> fetchFacilites();

}
