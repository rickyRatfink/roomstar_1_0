package com.seascape.roomstar.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.seascape.roomstar.domain.Employee;
import com.seascape.roomstar.domain.Role;

public class LoginForm  extends ActionForm {

	private Employee employee = new Employee();
	private Role role = new Role();
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		  ActionErrors errors = new ActionErrors();
		  if ((this.employee.getUsername()==null) || (this.employee.getUsername().length() < 1)) 
		      errors.add("",new ActionMessage("errors.required","username"));
		  if ((this.employee.getPassword()==null) || (this.employee.getPassword().length() < 1)) 
		      errors.add("", new ActionMessage("errors.required","password"));
		  
		  	 
		  return errors;
		}
}
