package com.seascape.roomstar.domain;

// Generated Sep 12, 2013 12:46:51 PM by Hibernate Tools 3.4.0.CR1

/**
 * ReservationMessage generated by hbm2java
 */
public class ReservationMessage implements java.io.Serializable {

	private Long reservationMessageId;
	private long reservationId;
	private String message;

	public ReservationMessage() {
	}

	public ReservationMessage(long reservationId, String message) {
		this.reservationId = reservationId;
		this.message = message;
	}

	public Long getReservationMessageId() {
		return this.reservationMessageId;
	}

	public void setReservationMessageId(Long reservationMessageId) {
		this.reservationMessageId = reservationMessageId;
	}

	public long getReservationId() {
		return this.reservationId;
	}

	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}