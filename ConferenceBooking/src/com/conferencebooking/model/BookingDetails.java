package com.conferencebooking.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "booking_details")
@Entity
public class BookingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "booking_id")
	private long bookingId;

	@Column(name = "start_time")
	private Date startTime;

	@Column(name = "end_time")
	private Date endTime;

	@Column(name = "metting_subject")
	private String meetingSubject;

	@ManyToOne
	@JoinColumn(name = "conference_room_id", nullable = false)
	private ConferenceRoom conferenceRoom;

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getMeetingSubject() {
		return meetingSubject;
	}

	public void setMeetingSubject(String meetingSubject) {
		this.meetingSubject = meetingSubject;
	}

	@Override
	public String toString() {
		return "BookingDetails [bookingId=" + bookingId + ", startTime="
				+ startTime + ", endTime=" + endTime + ", meetingSubject="
				+ meetingSubject + ", conferenceRoom=" + conferenceRoom + "]";
	}

}
