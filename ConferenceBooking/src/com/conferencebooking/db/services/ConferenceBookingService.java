package com.conferencebooking.db.services;

import java.util.List;

import com.conferencebooking.model.ConferenceRoom;
import com.conferencebooking.model.Facility;
import com.conferencebooking.model.Location;
import com.conferencebooking.model.Purpose;

public interface ConferenceBookingService {

	public void saveConfernceRoom();

	public List<ConferenceRoom> fetchConfernceRoom();

	public ConferenceRoom fetchConferenceRoom(int conferenceRoomId);

	public void saveLocation();

	public void saveFacility();

	public void savePurpose();

	public Location fetchLocation(int locationId);

	public List<Location> fetchAllLocation();

	public Purpose fetchPurpose(int locationId);

	public List<Purpose> fetchAllPurpose();

	public Facility fetchFacility(int facilityId);

	public List<Facility> fetchFacilites();

}
