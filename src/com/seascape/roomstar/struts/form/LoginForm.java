package com.seascape.roomstar.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginForm  extends ActionForm {

	private String username=null;
	private String password=null;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		  ActionErrors errors = new ActionErrors();
		  if ((username==null) || (username.length() < 1)) 
		      errors.add("",new ActionMessage("errors.required","username"));
		  if ((password==null) || (password.length() < 1)) 
		      errors.add("", new ActionMessage("errors.required","password"));
		  
		  	 
		  return errors;
		}
}
