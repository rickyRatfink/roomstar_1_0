package com.seascape.roomstar.domain;

// Generated Sep 14, 2013 1:58:13 PM by Hibernate Tools 3.4.0.CR1

/**
 * Employee generated by hbm2java
 */
public class Employee implements java.io.Serializable {

	private long employeeId;
	private long propertyId;
	private String firstName;
	private String lastName;
	private String middleName;
	private String username;
	private String password;
	private String creationDate;
	private String createdBy;
	private String lastLogin;
	private Long roleId;

	public Employee() {
	}

	public Employee(long employeeId, long propertyId, String firstName,
			String lastName, String username, String password) {
		this.employeeId = employeeId;
		this.propertyId = propertyId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}

	public Employee(long employeeId, long propertyId, String firstName,
			String lastName, String middleName, String username,
			String password, String creationDate, String createdBy,
			String lastLogin, Long roleId) {
		this.employeeId = employeeId;
		this.propertyId = propertyId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.username = username;
		this.password = password;
		this.creationDate = creationDate;
		this.createdBy = createdBy;
		this.lastLogin = lastLogin;
		this.roleId = roleId;
	}

	public long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public long getPropertyId() {
		return this.propertyId;
	}

	public void setPropertyId(long propertyId) {
		this.propertyId = propertyId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}
