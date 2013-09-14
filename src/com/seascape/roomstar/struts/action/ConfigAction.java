package com.seascape.roomstar.struts.action;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.seascape.roomstar.Constants;
import com.seascape.roomstar.hibernate.dao.RateTypeDao;
import com.seascape.roomstar.hibernate.dao.RoomTypeDao;
import com.seascape.roomstar.struts.form.ConfigForm;

public class ConfigAction extends Action {
	
	private final static Logger LOGGER = Logger.getLogger(RoomTypeDao.class.getName());

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {		
		LOGGER.setLevel(Level.INFO);

		 HttpSession session = request.getSession(false);
		 ConfigForm configForm = (ConfigForm)form;
		 
		 RateTypeDao rateTypeDao = new RateTypeDao();
		 RoomTypeDao roomTypeDao = new RoomTypeDao();
		 
		 if ("roomType".equals(request.getParameter("entity"))) {
			 if ("Save".equals(request.getParameter("action"))) {
				 
				ArrayList errorList = this.validate(mapping, request, configForm);
				if (errorList.size()>0) {
					session.setAttribute("notifications", "error");
					session.setAttribute("errors", errorList);
					return mapping.findForward(Constants.ROOMTYPE_FAILURE);
				}
				roomTypeDao.addRoomType(configForm.getRoomType());
				session.setAttribute("notifications", "success");
				session.setAttribute("msg", "room type successfully saved.");
				return mapping.findForward(Constants.ROOMTYPE_SUCCESS);
			 }
			 
		 }
		 
		 if ("rateType".equals(request.getParameter("entity"))) {
			 if ("Save".equals(request.getParameter("action"))) {
				 
				ArrayList errorList = this.validate(mapping, request, configForm);
				if (errorList.size()>0) {
					session.setAttribute("notifications", "error");
					session.setAttribute("errors", errorList);
					return mapping.findForward(Constants.RATETYPE_FAILURE);
				}
				rateTypeDao.addRateType(configForm.getRateType());
				session.setAttribute("notifications", "success");
				session.setAttribute("msg", "rate type successfully saved.");
				return mapping.findForward(Constants.RATETYPE_SUCCESS);
			 }
			 
		 }
		
		 
		 return mapping.findForward(Constants.SUCCESS);
	}
	
	public ArrayList validate(ActionMapping mapping, HttpServletRequest request, ActionForm form) {
		  ActionErrors errors = new ActionErrors();
		 
		 ConfigForm configForm = (ConfigForm)form;
		 ArrayList errorList = new ArrayList();
		 
		  //validate RoomType
		 if ("roomType".equals(request.getParameter("entity"))) {
		  if (configForm.getRoomType().getName()==null || configForm.getRoomType().getName().length()<1)
			  errorList.add("display name is required.");
		 }
		 
		  //validate RoomType
		 if ("rateType".equals(request.getParameter("entity"))) {
		  if (configForm.getRateType().getName()==null || configForm.getRateType().getName().length()<1)
			  errorList.add("display name is required.");
		  if ((configForm.getRateType().getValue()+"").length()<1)
			  errorList.add("display name is required.");
		}
		 
 
		  return errorList;
		}
}
	
	