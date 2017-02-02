package com.conferencebooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.conferencebooking.db.services.ConferenceBookingServiceImpl;
import com.conferencebooking.model.Location;

@Controller
public class LocationController {

	@Autowired
	ConferenceBookingServiceImpl conferenceBookingServiceImpl;

	@RequestMapping(path = "locations", method = RequestMethod.GET)
	public String locations() {
		List<Location> locationList = conferenceBookingServiceImpl
				.fetchAllLocation();

		return Location.serialise(locationList);
	}

}
