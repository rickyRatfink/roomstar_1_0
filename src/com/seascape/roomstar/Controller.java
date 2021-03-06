package com.seascape.roomstar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seascape.roomstar.domain.AddressType;
import com.seascape.roomstar.domain.Amentity;
import com.seascape.roomstar.domain.Country;
import com.seascape.roomstar.domain.RateType;
import com.seascape.roomstar.domain.RoomType;
import com.seascape.roomstar.domain.State;
import com.seascape.roomstar.hibernate.dao.AddressTypeDao;
import com.seascape.roomstar.hibernate.dao.AmentityDao;
import com.seascape.roomstar.hibernate.dao.CountryDao;
import com.seascape.roomstar.hibernate.dao.RateTypeDao;
import com.seascape.roomstar.hibernate.dao.RoomTypeDao;
import com.seascape.roomstar.hibernate.dao.StateDao;
import com.seascape.roomstar.struts.form.ConfigForm;
import com.seascape.util.Validator;

public class Controller extends HttpServlet {

	private String URL = "";
	private Validator v = new Validator();
	private final static Logger LOGGER = Logger.getLogger(Controller.class
			.getName());

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		LOGGER.setLevel(Level.SEVERE);
		HttpSession session = request.getSession(true);

		 if (!v.isAuthenticated(request))		
			 URL="login.jsp";
		 
		try {
			String action = request.getParameter("action");
			String entity = request.getParameter("entity");
			this.loadDropDownList(session);

			if ("config".equals(action)) {
				if ("roomType".equals(entity)) 
					URL = "pages/admin/configuration/roomType.jsp";
				if ("rateType".equals(entity)) 
					URL = "pages/admin/configuration/rateType.jsp";
			} 
			else if ("WalkIn".equals(action)) 
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
        	
        	//Load Room Types
            RoomTypeDao dao = new RoomTypeDao();
            List<RoomType> list = new ArrayList<RoomType>();
            list=dao.listRoomTypes();
            session.setAttribute("ddl_roomType", list);
       		
            RateTypeDao dao1 = new RateTypeDao();
            List<RateType> list1 = new ArrayList<RateType>();
            list1=dao1.listRateTypes();
            session.setAttribute("ddl_rateType", list1);
            
            AddressTypeDao dao2 = new AddressTypeDao();
            List<AddressType> list2 = new ArrayList<AddressType>();
            list2=dao2.listAddressTypes();
            session.setAttribute("ddl_addressType", list2);
            
            StateDao dao3 = new StateDao();
            List<State> list3 = new ArrayList<State>();
            list3=dao3.listStates();
            session.setAttribute("ddl_state", list3);
            
            CountryDao dao4 = new CountryDao();
            List<Country> list4 = new ArrayList<Country>();
            list4=dao4.listCountrys();
            session.setAttribute("ddl_country", list4);
            
            AmentityDao dao5 = new AmentityDao();
            List<Amentity> list5 = new ArrayList<Amentity>();
            list5=dao5.listAmentitys();
            session.setAttribute("ddl_amentity", list5);
       
        }

}