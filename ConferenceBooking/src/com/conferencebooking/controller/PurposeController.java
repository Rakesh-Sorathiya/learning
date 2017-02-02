package com.conferencebooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.conferencebooking.db.services.ConferenceBookingServiceImpl;
import com.conferencebooking.model.Purpose;

@Controller
public class PurposeController {

	@Autowired
	ConferenceBookingServiceImpl conferenceBookingServiceImpl;

	@RequestMapping(path = "purposes", method = RequestMethod.GET)
	public String Purposes() {
		List<Purpose> purposeList = conferenceBookingServiceImpl
				.fetchAllPurpose();

		return Purpose.serialise(purposeList);
	}
}
