package com.conferencebooking.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Purpose.class)
public class Purpose_ {

	public static volatile SingularAttribute<Purpose, Long> purposeId;
	public static volatile SingularAttribute<Purpose, String> purpose;

}
