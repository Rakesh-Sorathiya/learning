package com.conferencebooking.db.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.conferencebooking.model.ConferenceRoom;
import com.conferencebooking.model.Facility;
import com.conferencebooking.model.Location;
import com.conferencebooking.model.Purpose;

/**
 * 
 * @author rakeshsor
 *
 */
@Service
public class ConferenceBookingServiceImpl implements ConferenceBookingService {

	private SessionFactory sessionFactory;

	public ConferenceBookingServiceImpl(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	@Override
	public void saveConfernceRoom(ConferenceRoom conferenceRoom) {
		save(conferenceRoom);
	}

	@Override
	public List<ConferenceRoom> fetchConfernceRoom(
			ConferenceRoom conferenceRoomSearchInput) {

		Session session = sessionFactory.openSession();

		Query query = session
				.createQuery("from ConferenceRoom where user_id=:id");
		// query.setString("id", con);

		return null;
	}

	@Override
	public ConferenceRoom fetchConferenceRoom(long conferenceRoomId) {
		return getWithIndex(conferenceRoomId, ConferenceRoom.class);
	}

	@Override
	public void saveLocation(Location location) {
		save(location);
	}

	@Override
	public void saveFacility(Facility facility) {
		save(facility);
	}

	@Override
	public void savePurpose(Purpose purpose) {
		save(purpose);
	}

	@Override
	public Location fetchLocation(int locationId) {
		return getWithIndex(locationId, Location.class);

	}

	@Override
	public List<Location> fetchAllLocation() {
		try (Session session = sessionFactory.openSession()) {
			Query query = session.createQuery("* from location");
			return ((query.getResultList()) == null ? new ArrayList<Location>()
					: new ArrayList<Location>(query.getResultList()));
		}

	}

	@Override
	public Purpose fetchPurpose(int purposeId) {
		return getWithIndex(purposeId, Purpose.class);

	}

	@Override
	public List<Purpose> fetchAllPurpose() {
		try (Session session = sessionFactory.openSession()) {
			Query query = session.createQuery("* from purpose");
			return ((query.getResultList()) == null ? new ArrayList<Purpose>()
					: new ArrayList<Purpose>(query.getResultList()));

		}
	}

	@Override
	public Facility fetchFacility(int facilityId) {
		return getWithIndex(facilityId, Facility.class);

	}

	@Override
	public List<Facility> fetchFacilites() {

		try (Session session = sessionFactory.openSession()) {
			Query query = session.createQuery("* from facilities");
			return ((query.getResultList()) == null ? new ArrayList<Facility>()
					: new ArrayList<Facility>(query.getResultList()));
		}

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private <T> void save(T Object) {
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(Object);
			transaction.commit();
		}
	}

	private <T> T getWithIndex(long index, Class<T> classType) {

		T object = null;
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			object = session.get(classType, index);
			transaction.commit();
		}
		return object;
	}
}
