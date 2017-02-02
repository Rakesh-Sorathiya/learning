package com.conferencebooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.conferencebooking.db.services.ConferenceBookingServiceImpl;
import com.conferencebooking.model.Facility;

@Controller
public class FacilityController {

	
	@Autowired
	ConferenceBookingServiceImpl conferenceBookingServiceImpl;

	@RequestMapping(path = "facilities", method = RequestMethod.GET)
	public String Facilities() {
		List<Facility> facilityList = conferenceBookingServiceImpl
				.fetchFacilites();

		return Facility.serialise(facilityList);
	}
}
