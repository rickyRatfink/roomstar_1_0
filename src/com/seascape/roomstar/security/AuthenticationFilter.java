package com.seascape.roomstar.security;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException; 
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seascape.roomstar.hibernate.dao.RoomTypeDao;

public class AuthenticationFilter implements Filter {

	private final static Logger LOGGER = Logger.getLogger(AuthenticationFilter.class.getName());
	
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		LOGGER.setLevel(Level.INFO);
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String url = request.getServletPath();
		String contextPath = request.getContextPath();

		LOGGER.log(Level.INFO,"CHECKING IF USER IS AUTHENTICATED");

		HttpSession session = request.getSession(false);
		if (null == session) {
			response.sendRedirect(contextPath + "/login.jsp");
		} else {
			String logged = (String) session.getAttribute("authenticated");
			if (logged == null || !"YES".equals(logged)) {
				response.sendRedirect(contextPath + "/login.jsp");
			} else
				chain.doFilter(request, response);

		}
	}

	public void init(FilterConfig config) throws ServletException {

	}

	public void destroy() {
	}

	/*
	 * private FilterConfig filterConfig = null;
	 * 
	 * public void doFilter(ServletRequest request, ServletResponse response,
	 * FilterChain chain) throws IOException, ServletException {
	 * 
	 * boolean authorized = false; if (request instanceof HttpServletRequest) {
	 * HttpSession session = ((HttpServletRequest) request) .getSession(false);
	 * if (session != null) { String flag =
	 * (String)session.getAttribute("authenticated"); if ("YES".equals(flag))
	 * authorized = true; } }
	 * 
	 * if (authorized) { chain.doFilter(request, response); return; } else {
	 * filterConfig.getServletContext() .getRequestDispatcher("/login.jsp")
	 * .forward(request, response); return;
	 * 
	 * }
	 * 
	 * 
	 * }
	 * 
	 * public void init(FilterConfig config) throws ServletException {
	 * 
	 * // Get init parameter String testParam =
	 * config.getInitParameter("test-param");
	 * 
	 * // Print the init parameter System.out.println("Test Param: " +
	 * testParam); filterConfig=config; }
	 * 
	 * public void destroy() { // add code to release any resource }
	 */
}
