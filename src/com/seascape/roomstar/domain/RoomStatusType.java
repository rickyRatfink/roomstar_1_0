package com.seascape.roomstar.domain;

// Generated Sep 12, 2013 12:46:51 PM by Hibernate Tools 3.4.0.CR1

/**
 * RoomStatusType generated by hbm2java
 */
public class RoomStatusType implements java.io.Serializable {

	private Long roomStatusTypeId;
	private String name;

	public RoomStatusType() {
	}

	public RoomStatusType(String name) {
		this.name = name;
	}

	public Long getRoomStatusTypeId() {
		return this.roomStatusTypeId;
	}

	public void setRoomStatusTypeId(Long roomStatusTypeId) {
		this.roomStatusTypeId = roomStatusTypeId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
