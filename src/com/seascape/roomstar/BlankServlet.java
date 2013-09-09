package com.seascape.roomstar;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
public class BlankServlet extends HttpServlet {

	 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			   throws ServletException, IOException
			   {
			      HttpSession session = req.getSession(true);
	 }
	 
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			 throws ServletException, IOException
			 {
			     doGet(req, resp);
			 }
}
