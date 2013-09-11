package com.seascape.roomstar.struts.form;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.seascape.roomstar.domain.Customer;
import com.seascape.roomstar.domain.RoomType;

public class WalkInForm extends ActionForm {

	
	private Customer customer = new Customer();
	 
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		
		ActionErrors errors = new ActionErrors();
		  if ((customer.getLastname()==null) || (customer.getLastname().length() < 1)) 
			  errors.add("",new ActionMessage("errors.required","lastname"));
		  	 
		  if (errors.size()>0)
			  request.setAttribute("notifications", "error");
		  
		  return errors;
		}
	
	
}
