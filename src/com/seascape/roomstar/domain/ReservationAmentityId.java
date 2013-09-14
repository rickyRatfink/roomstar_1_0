package com.seascape.roomstar.domain;

// Generated Sep 14, 2013 1:58:13 PM by Hibernate Tools 3.4.0.CR1

/**
 * ReservationAmentityId generated by hbm2java
 */
public class ReservationAmentityId implements java.io.Serializable {

	private long reservationId;
	private long amentityId;

	public ReservationAmentityId() {
	}

	public ReservationAmentityId(long reservationId, long amentityId) {
		this.reservationId = reservationId;
		this.amentityId = amentityId;
	}

	public long getReservationId() {
		return this.reservationId;
	}

	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}

	public long getAmentityId() {
		return this.amentityId;
	}

	public void setAmentityId(long amentityId) {
		this.amentityId = amentityId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ReservationAmentityId))
			return false;
		ReservationAmentityId castOther = (ReservationAmentityId) other;

		return (this.getReservationId() == castOther.getReservationId())
				&& (this.getAmentityId() == castOther.getAmentityId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getReservationId();
		result = 37 * result + (int) this.getAmentityId();
		return result;
	}

}
