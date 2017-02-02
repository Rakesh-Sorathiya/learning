package com.conferencebooking.model;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.conferencebooking.model.BookingDetails;
import com.conferencebooking.model.ConferenceRoom;
import com.conferencebooking.model.Facility;
import com.conferencebooking.model.Location;
import com.conferencebooking.model.Purpose;

@StaticMetamodel(ConferenceRoom.class)
public class ConferenceRoom_ {

	public static volatile SingularAttribute<ConferenceRoom, Long> conferenceRoomId;
	public static volatile SingularAttribute<ConferenceRoom, String> conferenceRoomName;
	public static volatile SingularAttribute<ConferenceRoom, Location> location;
	public static volatile ListAttribute<ConferenceRoom, Facility> facilities;
	public static volatile ListAttribute<ConferenceRoom, Purpose> conferenceRoomPurpose;
	public static volatile SingularAttribute<ConferenceRoom, Integer> conferenceRoomCapacity;
	public static volatile ListAttribute<ConferenceRoom, BookingDetails> bookingDetails;

}
