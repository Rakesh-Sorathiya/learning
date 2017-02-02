package com.conferencebooking.model;

import java.util.Date;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(BookingDetails.class)
public class BookingDetails_ {

	public static volatile SingularAttribute<BookingDetails, Long> bookingId;
	public static volatile SingularAttribute<BookingDetails, Date> startTime;
	public static volatile SingularAttribute<BookingDetails, Date> endTime;
	public static volatile SingularAttribute<BookingDetails, String> meetingSubject;
	public static volatile SingularAttribute<ConferenceRoom, ConferenceRoom> conferneceRoom;

}
