package com.seascape.roomstar.domain;

// Generated Sep 14, 2013 1:58:13 PM by Hibernate Tools 3.4.0.CR1

/**
 * RoomRate generated by hbm2java
 */
public class RoomRate implements java.io.Serializable {

	private long roomRateId;
	private long roomId;
	private long rateTypeId;

	public RoomRate() {
	}

	public RoomRate(long roomRateId, long roomId, long rateTypeId) {
		this.roomRateId = roomRateId;
		this.roomId = roomId;
		this.rateTypeId = rateTypeId;
	}

	public long getRoomRateId() {
		return this.roomRateId;
	}

	public void setRoomRateId(long roomRateId) {
		this.roomRateId = roomRateId;
	}

	public long getRoomId() {
		return this.roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public long getRateTypeId() {
		return this.rateTypeId;
	}

	public void setRateTypeId(long rateTypeId) {
		this.rateTypeId = rateTypeId;
	}

}
