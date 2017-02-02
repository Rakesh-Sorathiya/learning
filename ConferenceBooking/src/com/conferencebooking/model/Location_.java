package com.conferencebooking.model;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.conferencebooking.model.ConferenceRoom;
import com.conferencebooking.model.Location;

@StaticMetamodel(Location.class)
public class Location_ {

	public static volatile SingularAttribute<Location, Integer> locationId;
	public static volatile SingularAttribute<Location, String> location;
	public static volatile ListAttribute<Location, ConferenceRoom> conferenceRoomList;
}
