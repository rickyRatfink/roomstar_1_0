package com.seascape.roomstar.domain;

// Generated Sep 12, 2013 12:46:51 PM by Hibernate Tools 3.4.0.CR1

/**
 * RoomType generated by hbm2java
 */
public class RoomType implements java.io.Serializable {

	private Long roomTypeId;
	private String name;

	public RoomType() {
	}

	public RoomType(String name) {
		this.name = name;
	}

	public Long getRoomTypeId() {
		return this.roomTypeId;
	}

	public void setRoomTypeId(Long roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
