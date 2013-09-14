package com.seascape.roomstar.struts.action;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;

import com.seascape.roomstar.Constants;
import com.seascape.roomstar.domain.Employee;
import com.seascape.roomstar.domain.Role;
import com.seascape.roomstar.hibernate.dao.EmployeeDao;
import com.seascape.roomstar.hibernate.dao.RoleDao;
import com.seascape.roomstar.hibernate.dao.RoomTypeDao;
import com.seascape.roomstar.struts.form.LoginForm;

public class LoginAction extends Action {
	
	private final static Logger LOGGER = Logger.getLogger(RoomTypeDao.class.getName());

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {		
		LOGGER.setLevel(Level.INFO);

		 HttpSession session = request.getSession(false);
		 
		 if ("logout".equals(request.getParameter("action"))) {
			 session.invalidate();
			 return mapping.findForward(Constants.AUTHENTICATE);
		 }
		 EmployeeDao employeeDao = new EmployeeDao();
		 RoleDao roleDao = new RoleDao();
		 
		 ActionRedirect redirect = null;
		 LoginForm loginForm = (LoginForm)form;
		 LOGGER.log(Level.INFO, "In login action..."+loginForm.getEmployee().getUsername());
		 Employee employee = employeeDao.authenticate(loginForm.getEmployee().getUsername(), loginForm.getEmployee().getPassword());
		 if (employee!=null) {
			 Role role = roleDao.findById(employee.getRoleId());
			 session.setAttribute("employee", employee);
			 session.setAttribute("role", role);
			 
			 return mapping.findForward(Constants.SUCCESS);
		 } else {
			 return mapping.findForward(Constants.FAILURE);
		 }
   
	}
	
}
