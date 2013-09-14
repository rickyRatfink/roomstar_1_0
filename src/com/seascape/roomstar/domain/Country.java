package com.seascape.roomstar.domain;

// Generated Sep 14, 2013 1:58:13 PM by Hibernate Tools 3.4.0.CR1

/**
 * Country generated by hbm2java
 */
public class Country implements java.io.Serializable {

	private String iso;
	private String label;
	private String printableName;
	private String iso3;
	private Short numcode;

	public Country() {
	}

	public Country(String iso, String label, String printableName) {
		this.iso = iso;
		this.label = label;
		this.printableName = printableName;
	}

	public Country(String iso, String label, String printableName, String iso3,
			Short numcode) {
		this.iso = iso;
		this.label = label;
		this.printableName = printableName;
		this.iso3 = iso3;
		this.numcode = numcode;
	}

	public String getIso() {
		return this.iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getPrintableName() {
		return this.printableName;
	}

	public void setPrintableName(String printableName) {
		this.printableName = printableName;
	}

	public String getIso3() {
		return this.iso3;
	}

	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}

	public Short getNumcode() {
		return this.numcode;
	}

	public void setNumcode(Short numcode) {
		this.numcode = numcode;
	}

}
