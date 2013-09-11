package com.seascape.roomstar.struts.action;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.seascape.roomstar.Constants;
import com.seascape.roomstar.hibernate.dao.RoomTypeDao;
import com.seascape.roomstar.struts.form.WalkInForm;
import com.seascape.util.Validator;

public class WalkInAction  extends Action {
	
	private final static Logger LOGGER = Logger.getLogger(RoomTypeDao.class.getName());
	private static Validator v = new Validator();
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {		
		LOGGER.setLevel(Level.INFO);
		
		 if (!v.isAuthenticated(request))		
			 return mapping.findForward(Constants.AUTHENTICATE);

		
		 WalkInForm walkInForm = (WalkInForm)form;
		 return mapping.findForward(Constants.SUCCESS);
		
	}
}