package com.seascape.roomstar.domain;

// Generated Sep 14, 2013 1:58:13 PM by Hibernate Tools 3.4.0.CR1

/**
 * Customer generated by hbm2java
 */
public class Customer implements java.io.Serializable {

	private Long customerId;
	private String firstname;
	private String lastname;
	private String suffix;
	private String creationDate;
	private String createdBy;
	private String rewardsNumber;
	private String organization;
	private String notes;

	public Customer() {
	}

	public Customer(String firstname, String lastname, String suffix,
			String creationDate, String createdBy, String rewardsNumber,
			String organization, String notes) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.suffix = suffix;
		this.creationDate = creationDate;
		this.createdBy = createdBy;
		this.rewardsNumber = rewardsNumber;
		this.organization = organization;
		this.notes = notes;
	}

	public Long getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getSuffix() {
		return this.suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getRewardsNumber() {
		return this.rewardsNumber;
	}

	public void setRewardsNumber(String rewardsNumber) {
		this.rewardsNumber = rewardsNumber;
	}

	public String getOrganization() {
		return this.organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
