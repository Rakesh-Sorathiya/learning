package com.conferencebooking.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.conferencebooking.db.services.ConferenceBookingService;
import com.conferencebooking.model.ConferenceRoom;
import com.conferencebooking.model.Facility;
import com.conferencebooking.model.Location;
import com.conferencebooking.model.Purpose;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "appServlet-servlet.xml" })
public class ConferenceBookingImplTest {

	private static final Object NULL = null;

	@Autowired
	@Qualifier("conferenceBookingServiceImpl")
	ConferenceBookingService conferenceBookingServiceImpl;

	@Test
	public void testSaveConfernceRoom() {

		ConferenceRoom conferenceRoom = new ConferenceRoom();

		conferenceRoom.setConferenceRoomId(5524);
		conferenceRoom.setConferenceRoomCapacity(7);
		conferenceRoom.setConferenceRoomName("Jupiter");

		Location location = conferenceBookingServiceImpl.fetchLocation(1);
		conferenceRoom.setLocation(location);

		List<Purpose> conferenceRoomPurpose = new ArrayList<Purpose>();

		Purpose p = conferenceBookingServiceImpl.fetchPurpose(1);
		conferenceRoomPurpose.add(p);
		conferenceRoom.setConferenceRoomPurpose(conferenceRoomPurpose);

		Facility f = conferenceBookingServiceImpl.fetchFacility(1);
		List<Facility> fList = conferenceRoom.getFacilities();
		conferenceRoom.setFacilities(fList);

		conferenceBookingServiceImpl.saveConfernceRoom(conferenceRoom);

	}

	@Test
	public void FetchConfernceRoomTest() {

	}

	@Test
	public void fetchConferenceRoomTest() {
		conferenceBookingServiceImpl.fetchConferenceRoom(0);
	}

	@Test
	public void saveLocationTest() {
		Location location = new Location();
		location.setLocation("Pune");
		conferenceBookingServiceImpl.saveLocation(location);

		System.out.println("Location Id" + location.getLocationId());
	}

	@Test
	public void testSaveFacility() {

		Facility facility = new Facility();
		facility.setFacility("Projector");
		conferenceBookingServiceImpl.saveFacility(facility);
	}

	@Test
	public void testSavePurpose() {

		Purpose purpose = new Purpose();
		purpose.setPurpose("Client Call");

	}

	@Test
	public void testFetchLocation() {
		Location location = conferenceBookingServiceImpl.fetchLocation(1);
		Assert.assertNotEquals(NULL, location);

	}

	@Test
	public void testFetchAllLocation() {

	}

	@Test
	public void testFetchPurpose() {

	}

	@Test
	public void fetchAllPurpose() {

	}

	@Test
	public void fetchFacility() {

	}

	@Test
	public void fetchFacilites() {

	}
}
