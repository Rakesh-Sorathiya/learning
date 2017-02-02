package com.conferencebooking.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Facility.class)
public class Facility_ {

	public static volatile SingularAttribute<Facility, Integer> facilityId;
	public static volatile SingularAttribute<Facility, String> facility;

}
