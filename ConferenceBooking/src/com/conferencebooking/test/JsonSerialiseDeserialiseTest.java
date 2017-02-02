package com.conferencebooking.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.conferencebooking.model.Facility;
import com.conferencebooking.model.Location;
import com.conferencebooking.model.Purpose;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "appServlet-servlet.xml" })
public class JsonSerialiseDeserialiseTest {

	@Test
	public void testLocationListSerialise() {

		Location location = new Location();

		location.setLocation("Pune");
		location.setLocationId(1);

		List<Location> locationList = new ArrayList<>();
		locationList.add(location);
		locationList.add(location);
		locationList.add(location);
		String jsonLocation = Location.serialise(locationList);
		Assert.assertEquals(
				"[{\"location\":\"Pune\",\"locationId\":1},{\"location\":\"Pune\",\"locationId\":1},{\"location\":\"Pune\",\"locationId\":1}]",
				jsonLocation);

	}

	@Test
	public void testFacilityListSerialise() {

		Facility facility = new Facility();
		facility.setFacility("Projector");
		facility.setFacilityId(1);

		List<Facility> facilityList = new ArrayList<>();
		facilityList.add(facility);
		facilityList.add(facility);
		facilityList.add(facility);
		String jsonFacility = Facility.serialise(facilityList);
		Assert.assertEquals(
				"[{\"facility\":\"Projector\",\"facilityId\":1},{\"facility\":\"Projector\",\"facilityId\":1},{\"facility\":\"Projector\",\"facilityId\":1}]",
				jsonFacility);
	}

	@Test
	public void testPurposeListSerialise() {

		Purpose purpose = new Purpose();
		purpose.setPurpose("Client Call");
		purpose.setPurposeId(1);

		List<Purpose> purposeList = new ArrayList<>();
		purposeList.add(purpose);
		purposeList.add(purpose);
		purposeList.add(purpose);
		String jsonPurpose = Purpose.serialise(purposeList);
		Assert.assertEquals(
				"[{\"purpose\":\"Client Call\",\"purposeId\":1},{\"purpose\":\"Client Call\",\"purposeId\":1},{\"purpose\":\"Client Call\",\"purposeId\":1}]",
				jsonPurpose);
	}

}
