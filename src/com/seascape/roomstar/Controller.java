package com.seascape.roomstar;

import com.seascape.roomstar.domain.RoomType;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seascape.roomstar.hibernate.dao.RoomTypeDao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Controller extends HttpServlet {

	private String URL = "";
	private final static Logger LOGGER = Logger.getLogger(Controller.class
			.getName());

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		LOGGER.setLevel(Level.SEVERE);
		HttpSession session = request.getSession(true);

		try {
			String action = request.getParameter("action");
			this.loadDropDownList(session);

			if ("Walk In".equals(action)) 
				URL = "pages/frontDesk/walkIn.jsp";
			else if ("Reservations".equals(action))
				URL = "pages/frontDesk/reservation.jsp";
			else if ("Folio".equals(action))
				URL = "pages/frontDesk/folio.jsp";
		} catch (Exception e) {
			session.setAttribute("SYSTEM_ERR", e.getMessage());
			LOGGER.log(Level.SEVERE,e.getMessage());
			URL = "pages/error.jsp";
		}
		request.getRequestDispatcher("/" + URL).forward(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
        
        private void loadDropDownList(HttpSession session) {
            
            RoomTypeDao dao = new RoomTypeDao();
            List<RoomType> list = new ArrayList<RoomType>();
            list=dao.listRoomTypes();
            session.setAttribute("ddl_roomType", list);
        }

}