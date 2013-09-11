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
import org.apache.struts.action.ActionRedirect;

import com.seascape.roomstar.Constants;
import com.seascape.roomstar.hibernate.dao.RoomTypeDao;
import com.seascape.roomstar.struts.form.LoginForm;

public class LoginAction extends Action {
	
	private final static Logger LOGGER = Logger.getLogger(RoomTypeDao.class.getName());

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {		
		LOGGER.setLevel(Level.INFO);

		 ActionRedirect redirect = null;
		 LoginForm loginForm = (LoginForm)form;
		 LOGGER.log(Level.INFO, "In login action..."+loginForm.getUsername()+loginForm.getPassword());
			
         if("admin".equals(loginForm.getUsername()) && "admin".equals(loginForm.getPassword())) {
        	 request.getSession(true).setAttribute("authenticated", "YES");
        	 return mapping.findForward(Constants.SUCCESS);
         } else {
        	 return mapping.findForward(Constants.FAILURE);
         }    
   
	}
	
}
