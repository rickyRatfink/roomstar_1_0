package com.seascape.roomstar.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.seascape.roomstar.domain.Address;
import com.seascape.roomstar.domain.Customer;
import com.seascape.roomstar.domain.Reservation;

public class WalkInForm extends ActionForm {

	
	private Customer customer = new Customer();
	private Reservation reservation = new Reservation();
	private Address address = new Address();
	 
	
	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

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

		  if ((customer.getFirstname()==null) || (customer.getFirstname().length() < 1)) 
			  errors.add("",new ActionMessage("errors.required","firstname"));

		  if ((address.getLine1()==null) || (address.getLine1().length() < 1)) 
			  errors.add("",new ActionMessage("errors.required","address line1"));

		  if ((address.getCity()==null) || (address.getCity().length() < 1)) 
			  errors.add("",new ActionMessage("errors.required","city"));

		  if ((address.getState()==null) || (address.getState().length() < 1)) 
			  errors.add("",new ActionMessage("errors.required","state"));

		  if ((address.getCountry()==null) || (address.getCountry().length() < 1)) 
			  errors.add("",new ActionMessage("errors.required","country"));

		  if ((address.getZipcode()==null) || (address.getZipcode().length() < 1)) 
			  errors.add("",new ActionMessage("errors.required","zipcode"));

		  if (errors.size()>0)
			  request.setAttribute("notifications", "error");
		  
		  return errors;
		}
	
	
}
