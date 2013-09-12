package com.seascape.roomstar.struts.action;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.seascape.roomstar.Constants;
import com.seascape.roomstar.hibernate.dao.AddressDao;
import com.seascape.roomstar.hibernate.dao.CustomerDao;
import com.seascape.roomstar.hibernate.dao.ReservationDao;
import com.seascape.roomstar.hibernate.dao.RoomTypeDao;
import com.seascape.roomstar.struts.form.WalkInForm;
import com.seascape.util.Validator;

public class WalkInAction  extends Action {
	
	private final static Logger LOGGER = Logger.getLogger(RoomTypeDao.class.getName());
	private static Validator v = new Validator();
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {		
		LOGGER.setLevel(Level.INFO);
		
		 String action = request.getParameter("action");
		 WalkInForm walkInForm = (WalkInForm)form;
		 CustomerDao customerDao = new CustomerDao();
		 ReservationDao reservationDao = new ReservationDao();
		 AddressDao addressDao = new AddressDao();
		 
		 if ("Save".equals(action)) {
			 walkInForm.getCustomer().setCreationDate(v.getEpoch()+"");
			 walkInForm.getCustomer().setCreatedBy("Administrator");
			 Long customerId = customerDao.addCustomer(walkInForm.getCustomer());

			 walkInForm.getAddress().setCustomerId(customerId);
			 Long addressId = addressDao.addAddress(walkInForm.getAddress());

			 walkInForm.getReservation().setCustomerId(customerId);
			 walkInForm.getReservation().setCreationDate(v.getEpoch()+"");
			 walkInForm.getReservation().setCreatedBy("Administrator");
			 Long reservationId = reservationDao.addReservation(walkInForm.getReservation());
			 
			 request.getSession(false).setAttribute("confirmation", reservationId+"");
			 
		 }
		 return mapping.findForward(Constants.SUCCESS);
		
	}
}