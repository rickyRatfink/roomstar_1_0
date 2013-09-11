package com.seascape.roomstar.struts.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.seascape.roomstar.domain.RoomType;

public class HtmlSelectOption implements Serializable {

	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}
	private String label;
	private Long value;

	
	
	
}
