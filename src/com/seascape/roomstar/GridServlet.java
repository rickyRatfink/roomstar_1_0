package com.seascape.roomstar;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seascape.util.Validator;



public class GridServlet extends HttpServlet {
	
	private final static Logger LOGGER = Logger.getLogger(GridServlet.class.getName());
	
	private static final long serialVersionUID = 1L;
	private Validator valid8r = new Validator();
	private static String firstName = "";
	private static String lastName = "";
	private static String mi = "";
	private static String entryDate = "";
	private static String exitDate = "";
	private static String dob = "";
	private static String ssn = "";
	private static String archivedFlag = "";
	private static String pictureFlag = "";
	private static String gedFlag = "";
	private static String farm="";
	
	private String SERVER = "";
	private String uid = "";
	private String pwd = "";
	private String database = "";

	// private String SERVER = "ffarm_staging";
	// private String pwd="j35u59538";

	public GridServlet() {
		super();
	}
	
	private Connection getConnection() throws SQLException,
	ClassNotFoundException {

		LOGGER.setLevel(Level.ALL);
		
		Properties prop = new Properties();
	    //Connection Conn = null;
    	try {
            //load a properties file
    		//prop.load(new FileInputStream("c:\\development\\workspace\\dispatch_2_1\\src\\properties\\config.properties"));
    		prop.load(new FileInputStream("c:\\properties\\config.properties"));
    		this.setUid(prop.getProperty("dbuser")); 
    		this.setPwd(prop.getProperty("dbpassword"));
    		this.setDatabase(prop.getProperty("database"));
    		this.setSERVER(prop.getProperty("dburl"));  
     			 
    	} catch (IOException ex) { 
    		LOGGER.log(Level.SEVERE, ex.getMessage());
    	}
    	
		Class.forName("com.mysql.jdbc.Driver");
        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	//System.out.println ("jdbc:mysql://"+this.getSERVER()+"/" + database+","+ uid+","+ pwd);
		Connection Conn = DriverManager.getConnection(
				"jdbc:mysql://"+this.getSERVER()+"/" + this.getDatabase(), this.getUid(), this.getPwd());
		//Connection Conn = DriverManager.getConnection(
		//		"jdbc:sqlserver://"+this.getSERVER()+"/" + this.getDatabase(), this.getUid(), this.getPwd());
		 if (Conn==null)System.out.println("connection is null");


		
		return Conn;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

		
    response.setContentType("text/xml");
    response.addHeader("Cache-Control", "no-cache");
    String resultType=request.getParameter("type");
    
     StringBuffer data = new StringBuffer();
     
     //if ("student".equals(resultType)) 
    	 data=this.studentXml("",request);
     //if ("application".equals(resultType)) 
     //	 data=this.studentXml("PENDING",request);
  
    	 response.getWriter().write(data.toString());
    
  }

	private StringBuffer studentXml(String status, HttpServletRequest req) {
	 	 
		HttpSession session = req.getSession();
		
		ResultSet rs = null;
		StringBuffer data = new StringBuffer("");
		
		int count = 0, totalpages = 0, start = 0, row = 0;

		int page, limit;

		String sidx = "1", sord = "desc";

		try {
			page = Integer.parseInt(req.getParameter("page"));
		} catch (Exception nullexp) {
			page = 1;
		}

		try {
			limit = Integer.parseInt(req.getParameter("rows"));
		} catch (Exception nullexp) {
			limit = 20;
		}

		try {
			sidx = req.getParameter("sidx");
		} catch (Exception nullexp) {
			sidx = "1";
		}

		try {
			sord = req.getParameter("sord");
		} catch (Exception nullexp) {
			sord = "desc";
		}

		try {

			//connection = this.getConnection();
			
			//Class.forName("com.mysql.jdbc.Driver");
	        Connection connection = this.getConnection();
	      		
	        //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ffarm_prod", "root", "webmaster#59");
	        //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ffarm_dev", "root", "admin");
		    //this.setDatabase("ffarm_dev");
		    //this.setDatabase("ffarm_prod");
	        //System.out.println ("connectted..."); 
			StringBuffer selectQuery = new StringBuffer("");
			selectQuery.append("select count(*)  FROM `"+this.getDatabase()+"`.`intake`  ");
			selectQuery.append(" WHERE");
			selectQuery.append(" 1=1 ");
				if (firstName.length()>0)
					selectQuery.append(" AND FIRSTNAME='"+firstName +"'");
				if (lastName.length()>0)
					selectQuery.append(" AND LASTNAME='"+ lastName+"'");
				if (ssn.length()>0)
					selectQuery.append(" AND SSN='"+ ssn +"'");
				if (dob.length()>0)
					selectQuery.append(" AND DOB='"+ dob +"'");
				if (entryDate.length()>0&&exitDate.length()>0)
					selectQuery.append(" AND ENTRY_DATE BETWEEN'"+ entryDate +"' AND '"+exitDate+"'");
				if (!"ALL".equals(farm)&&!"".equals(farm))
					selectQuery.append(" AND FARM_BASE='"+farm +"'");
				
				if (status.length()>0)
					selectQuery.append(" AND APPLICATION_STATUS='"+status +"'");
				else
					selectQuery.append(" AND APPLICATION_STATUS NOT IN ('PENDING','DENIED') ");
			
			rs = connection.createStatement().executeQuery(selectQuery.toString());
			
			if (rs.next())
				count = rs.getInt(1);

			if (count > 0)
				totalpages = (int) (count) / limit;
			else
				totalpages = 0;

			if (page > totalpages)
				page = totalpages;

			start = (limit * page) - limit;
			if (start<0)
				start=0;
			
		//if (count>0) {
			selectQuery = new StringBuffer("");
			selectQuery.append("SELECT ");
			selectQuery.append(" INTAKE_ID,");
			selectQuery.append(" LASTNAME, ");
			selectQuery.append(" FIRSTNAME, ");
			selectQuery.append(" if (MI is null,'',MI), ");
			selectQuery.append(" SSN,");
			selectQuery.append(" if (DOB is null,'',DOB),");
			selectQuery.append(" APPLICATION_STATUS, ");
			selectQuery.append(" FARM_BASE, CONCAT(CITY,', ',STATE) AS LOCATION ");
			selectQuery.append(" FROM `"+this.getDatabase()+"`.`intake`  ");
			selectQuery.append(" WHERE");
			selectQuery.append(" 1=1 ");
				if (firstName.length()>0)
					selectQuery.append(" AND FIRSTNAME='"+firstName +"'");
				if (lastName.length()>0)
					selectQuery.append(" AND LASTNAME='"+ lastName+"'");
				if (ssn.length()>0)
					selectQuery.append(" AND SSN='"+ ssn +"'");
				if (dob.length()>0)
					selectQuery.append(" AND DOB='"+ dob +"'");
				if (entryDate.length()>0&&exitDate.length()>0)
					selectQuery.append(" AND ENTRY_DATE BETWEEN'"+ entryDate +"' AND '"+exitDate+"'");
				if (!"ALL".equals(farm)&&!"".equals(farm))
					selectQuery.append(" AND FARM_BASE='"+farm +"'");
				if (status.length()>0)
					selectQuery.append(" AND APPLICATION_STATUS='"+status +"'");
				else
					selectQuery.append(" AND APPLICATION_STATUS NOT IN ('PENDING','DENIED') ");
	
				selectQuery.append(" order by "+sidx + " "+sord+ " limit "+limit+ " offset "+start);
				;
				
				rs = connection.createStatement().executeQuery(selectQuery.toString());
	
				data = new StringBuffer();
	
				data.append("<?xml version=\"1.0\"?>\n");
				data.append("<rows>");
				data.append("<page>" + page + "</page>");
				data.append("<total>" + totalpages + "</total>");
				data.append("<records>" + count + "</records>");
				
				while (rs.next()) {
					data.append("<row id='" + rs.getString(1) + "'>");
					data.append("<cell>" + rs.getString(1) + "</cell>");
					data.append("<cell>" + rs.getString(2) + "</cell>");
					data.append("<cell>" + rs.getString(4) + "</cell>");
					data.append("<cell>" + rs.getString(3) + "</cell>");
					data.append("<cell>" + rs.getString(5) + "</cell>");
					data.append("<cell>" + rs.getString(6) + "</cell>");
					data.append("<cell>" + rs.getString(7) + "</cell>");
					data.append("<cell>" + rs.getString(8) + "</cell>");
					data.append("<cell>" + rs.getString(9) + "</cell>");
					data.append("</row>");
					++row;
				} 
				
				if (row==0){
					data.append("<row id='1'>");
					data.append("<cell>No Results</cell>");
					data.append("<cell></cell>");
					data.append("<cell></cell>");
					data.append("<cell></cell>");
					data.append("<cell></cell>");
					data.append("<cell></cell>");
					data.append("<cell></cell>");
					data.append("<cell></cell>");
					data.append("<cell></cell>");
					data.append("</row>");
					
					for (int i=2;i<22;i++) {
						data.append("<row id='"+i+"'>");
						data.append("<cell></cell>");
						data.append("<cell></cell>");
						data.append("<cell></cell>");
						data.append("<cell></cell>");
						data.append("<cell></cell>");
						data.append("<cell></cell>");
						data.append("<cell></cell>");
						data.append("<cell></cell>");
						data.append("<cell></cell>");
						data.append("</row>");	
					}
				}
				
				data.append("</rows>");
	
	/*			int height=450;
				if (row<20)
					height=row*25;
				
				session.setAttribute("grid_height", height);
				*/
				connection.close();
				rs.close();
		//}
		//req.getSession().setAttribute("rows",new Integer(row));
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		} 
		
		return data;
	}

	public static String getFirstName() {
		return firstName;
	}

	public static void setFirstName(String firstName) {
		GridServlet.firstName = firstName;
	}

	public static String getLastName() {
		return lastName;
	}

	public static void setLastName(String lastName) {
		GridServlet.lastName = lastName;
	}

	public static String getMi() {
		return mi;
	}

	public static void setMi(String mi) {
		GridServlet.mi = mi;
	}

	public static String getEntryDate() {
		return entryDate;
	}

	public static void setEntryDate(String entryDate) {
		GridServlet.entryDate = entryDate;
	}

	public static String getExitDate() {
		return exitDate;
	}

	public static void setExitDate(String exitDate) {
		GridServlet.exitDate = exitDate;
	}

	public static String getDob() {
		return dob;
	}

	public static void setDob(String dob) {
		GridServlet.dob = dob;
	}

	public static String getSsn() {
		return ssn;
	}

	public static void setSsn(String ssn) {
		GridServlet.ssn = ssn;
	}

	public static String getArchivedFlag() {
		return archivedFlag;
	}

	public static void setArchivedFlag(String archivedFlag) {
		GridServlet.archivedFlag = archivedFlag;
	}

	public static String getPictureFlag() {
		return pictureFlag;
	}

	public static void setPictureFlag(String pictureFlag) {
		GridServlet.pictureFlag = pictureFlag;
	}

	public static String getGedFlag() {
		return gedFlag;
	}

	public static void setGedFlag(String gedFlag) {
		GridServlet.gedFlag = gedFlag;
	}

	public static String getFarm() {
		return farm;
	}

	public static void setFarm(String farm) {
		GridServlet.farm = farm;
	}

	public String getSERVER() {
		return SERVER;
	}

	public void setSERVER(String sERVER) {
		SERVER = sERVER;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}
	
}
