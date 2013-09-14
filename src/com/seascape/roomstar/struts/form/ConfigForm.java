package com.seascape.roomstar.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.seascape.roomstar.domain.Amentity;
import com.seascape.roomstar.domain.RateType;
import com.seascape.roomstar.domain.RoomInventory;
import com.seascape.roomstar.domain.RoomType;
import com.seascape.roomstar.Constants;

public class ConfigForm extends ActionForm {

	private RoomType roomType = new RoomType();
	private RateType rateType = new RateType();
	private Amentity amentity = new Amentity();
	private RoomInventory roomInventory = new RoomInventory();
	private String errAction = "";
	
	public RoomType getRoomType() {
		return roomType;
	}


	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}


	public RateType getRateType() {
		return rateType;
	}



	public void setRateType(RateType rateType) {
		this.rateType = rateType;
	}



	public Amentity getAmentity() {
		return amentity;
	}



	public void setAmentity(Amentity amentity) {
		this.amentity = amentity;
	}



	public RoomInventory getRoomInventory() {
		return roomInventory;
	}



	public void setRoomInventory(RoomInventory roomInventory) {
		this.roomInventory = roomInventory;
	}



	public String getErrAction() {
		return errAction;
	}


	public void setErrAction(String errAction) {
		this.errAction = errAction;
	}

/*
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		  ActionErrors errors = new ActionErrors();
		 
		  //validate RoomType
		 if ("roomType".equals(request.getParameter("entity"))) {
		  if (roomType.getName()==null || roomType.getName().length()<1)
			  errors.add("", new ActionMessage("errors.required","room type name"));
		 }
		 
		  //validate RoomType
		 if ("rateType".equals(request.getParameter("entity"))) {
		  if (rateType.getName()==null || rateType.getName().length()<1)
			  errors.add("", new ActionMessage("errors.required","rate type name"));
		 }
		 
		  if (errors.size()>0)
			  request.setAttribute("notifications", "error");
		  
		  return errors;
		}*/
}
