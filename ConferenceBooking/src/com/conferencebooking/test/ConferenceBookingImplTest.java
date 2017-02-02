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
import com.conferencebooking.model.SearchBooking;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "appServlet-servlet.xml" })
public class ConferenceBookingImplTest {

	private static final Object NULL = null;

	@Autowired
	@Qualifier("conferenceBookingServiceImpl")
	ConferenceBookingService conferenceBookingServiceImpl;

	@Test
	public void testA_SaveFacility() {

		Facility facility = new Facility();
		facility.setFacility("Projector");
		conferenceBookingServiceImpl.saveFacility(facility);
	}

	@Test
	public void testB_SavePurpose() {

		Purpose purpose = new Purpose();
		purpose.setPurpose("Client Call");
		conferenceBookingServiceImpl.savePurpose(purpose);

	}

	@Test
	public void testC_saveLocation() {
		Location location = new Location();
		location.setLocation("Pune");
		conferenceBookingServiceImpl.saveLocation(location);

		System.out.println("Location Id" + location.getLocationId());
	}

	@Test
	public void testD_SaveConfernceRoom() {

		ConferenceRoom conferenceRoom = new ConferenceRoom();

		conferenceRoom.setConferenceRoomId(5529);
		conferenceRoom.setConferenceRoomCapacity(7);
		conferenceRoom.setConferenceRoomName("Jupiter");

		Location location = conferenceBookingServiceImpl.fetchLocation(1);
		conferenceRoom.setLocation(location);

		List<Purpose> conferenceRoomPurpose = new ArrayList<Purpose>();

		Purpose p = conferenceBookingServiceImpl.fetchPurpose(2);
		conferenceRoomPurpose.add(p);
		conferenceRoom.setConferenceRoomPurpose(conferenceRoomPurpose);

		Facility f = conferenceBookingServiceImpl.fetchFacility(1);
		List<Facility> facilityTest = new ArrayList<Facility>();
		facilityTest.add(f);
		conferenceRoom.setFacilities(facilityTest);

		conferenceBookingServiceImpl.saveConfernceRoom(conferenceRoom);

	}

	@Test
	public void testE_FetchConfernceRoom() {

		ConferenceRoom conferenceRoom = conferenceBookingServiceImpl
				.fetchConferenceRoom(5524);
		Assert.assertNotEquals(NULL, conferenceRoom);
	}

	@Test
	public void testF_FetchConferenceRoom() {

		SearchBooking searchBooking = new SearchBooking();
		searchBooking.setCapacity(5);

		Location location = new Location();
		location.setLocation("Pune");
		searchBooking.setLocation(location);

		List<Facility> facilityList = new ArrayList<Facility>();
		Facility facility = new Facility();
		facility.setFacility("Projector");
		facilityList.add(facility);

		Purpose purpose = new Purpose();
		purpose.setPurpose("Client Call");
		purpose.setPurposeId(1);
		List<Purpose> purposeList = new ArrayList<>();
		purposeList.add(purpose);

		searchBooking.setPurpose(purpose);
		searchBooking.setFacilities(facilityList);

		List<ConferenceRoom> conferenceRoomList = conferenceBookingServiceImpl
				.fetchConfernceRoom(searchBooking);

		//System.out.println(conferenceRoomList.get(0).toString());
	}

	@Test
	public void testG_FetchLocation() {
		Location location = conferenceBookingServiceImpl.fetchLocation(1);
		Assert.assertNotEquals(NULL, location);

	}

	@Test
	public void testH_FetchAllLocation() {
		List<Location> locationlist = conferenceBookingServiceImpl
				.fetchAllLocation();
		Assert.assertNotEquals(NULL, locationlist);

	}

	@Test
	public void testI_FetchPurpose() {

		Purpose purpose = conferenceBookingServiceImpl.fetchPurpose(2);
		Assert.assertNotEquals(NULL, purpose);

	}

	@Test
	public void testJ_FetchAllPurpose() {

		List<Purpose> purposeList = conferenceBookingServiceImpl
				.fetchAllPurpose();
		Assert.assertNotEquals(NULL, purposeList);
	}

	@Test
	public void testK_FetchFacility() {

		Facility facility = conferenceBookingServiceImpl.fetchFacility(1);
		Assert.assertNotEquals(NULL, facility);
	}

	@Test
	public void testL_FetchFacilitesTest() {

		List<Facility> facilityList = conferenceBookingServiceImpl
				.fetchFacilites();
		Assert.assertNotEquals(NULL, facilityList);
	}

	@Test
	public void testK_FetchConferenceRoomTestWithLocationTest() {
		List<ConferenceRoom> conferenceRoomList = conferenceBookingServiceImpl
				.fetchConferenceRoom("Gandhinagar");
		Assert.assertNotEquals(NULL, conferenceRoomList);
	}

}
