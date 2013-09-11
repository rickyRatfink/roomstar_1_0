package com.seascape.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Validator {

	public static String validateRequired(String key, String value) {
		if ((value == null) || (value.length() == 0)
				|| (value.trim().length() == 0)) {
			return key + " is required.";
		}
		if ("ssn".equals(key)) {
			if ((value != null) && (value.length() < 9)
					|| (value.trim().length() == 0))
				return key + " is invalid.";
		}

		return "";
	}

	public static String validateRequired(String key, Long value) {
		if (value == null || value == 0) {
			return key + " is required.";
		}

		return "";
	}

	public static String validateEmail(String email) {
		if (("NA".equals(email)) || ("na".equals(email))) {
			return "";
		}
		if ((email == null) || (email.length() == 0)
				|| (email.trim().length() == 0)) {
			return "Email Address is required.";
		}
		Pattern p = Pattern
				.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher m = p.matcher(email);
		boolean b = m.matches();

		if (!b) {
			return "email address entered is not valid";
		}
		return "";
	}

	public static String validateOnlyLetters(String key, String value) {

		if (value == null || value.length() == 0)
			return "";

		Pattern p = Pattern.compile("[A-Za-z]+");
		Matcher m = p.matcher(value);
		boolean b = m.matches();

		if (!b) {
			return key + " must contain only letters";
		}
		return "";
	}

	public static String validateOnlyNumbers(String key, String value) {

		if (value == null || value.length() == 0)
			return "";

		Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(value);
		boolean b = m.matches();

		if (!b) {
			return key + " must contain only numbers";
		}
		return "";
	}

	public String validateDate(String key, String date) {

		Pattern pattern;
		Matcher matcher;

		/*String DATE_PATTERN = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)"; SUPPOSE TO WORK BUT DOESN'T
		String DATE_PATTERN = "\\d{2}/\\d{2}/\\d{4}"; //"(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
		
		pattern = Pattern.compile(DATE_PATTERN);
		matcher = pattern.matcher(date);

		if (matcher.matches()) {

			matcher.reset();

			if (matcher.find()) {

				String day = matcher.group(1);
				String month = matcher.group(2);
				int year = Integer.parseInt(matcher.group(3));

				if (day.equals("31")
						&& (month.equals("4") || month.equals("6")
								|| month.equals("9") || month.equals("11")
								|| month.equals("04") || month.equals("06") || month
									.equals("09"))) {
					return key + " is invalid"; // only 1,3,5,7,8,10,12 has 31
												// days
				} else if (month.equals("2") || month.equals("02")) {
					// leap year
					if (year % 4 == 0) {
						if (day.equals("30") || day.equals("31")) {
							return key + " is invalid";
						} else {
							return "";
						}
					} else {
						if (day.equals("29") || day.equals("30")
								|| day.equals("31")) {
							return key + " is invalid";
						} else {
							return "";
						}
					}
				} else {
					return "";
				}
			} else {
				return key + " is invalid";
			}
		} else {
			return key + " is invalid";
		}*/
		return "";
	}

	public static String validatePhone(String key, String phone) {

		if (phone == null || phone.length() == 0) {
			return "Contact Phone is required";
		}
		/*
		 * Pattern p = Pattern.compile(
		 * "^[\\(]{0,1}([0-9]){3}[\\)]{0,1}[ ]?([^0-1]){1}([0-9]){2}[ ]?[-]?[ ]?([0-9]){4}[ ]*((x){0,1}([0-9]){1,5}){0,1}$"
		 * ); Matcher m = p.matcher(phone); boolean b = m.matches();
		 * 
		 * if (!b) { return key+" must be in form (xxx)xxx-xxxx."; }
		 */
		return "";
	}

	public static String cleanData(String value) {
		if (value == null || value.equals("null")) {
			return "";
		}
		return value.replace("'", "''");
	}

	public static long getEpoch() {
		long epoch;
		Date date = new java.util.Date();
		epoch = date.getTime();
		return epoch;
	}

	public static String convertEpoch(Long epoch) {
		Date ddate = new java.util.Date(epoch);
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		return df.format(ddate);

	}
	
	public static String convertDate(String sDate) {
		Date ddate = new java.util.Date(sDate);
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		return df.format(ddate);

	}

	public boolean isAuthenticated(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		boolean authenticated=false;
		String flag = (String)session.getAttribute("authenticated");
		
		if ("YES".equals(flag))
			return true;
		else 
			return false;
	}
	/*
	  public static String decryptSsn(String base64) {
		       String clearSsn = base64;
		       try {
		         Cipher des = Cipher.getInstance("DES");
		         Key key = new SecretKeySpec("potatoes".getBytes(), "DES");
		         des.init(2, key);
		         clearSsn = new String(des.doFinal(Base64.decodeBase64(base64.getBytes())));
		       } catch (BadPaddingException e) {
		         System.out.println("BadPaddingException in decryptSsn: " + e.getMessage());
		       } catch (Exception e) {
		         System.out.println("General exception in decryptSsn: " + e.getMessage());
		       }
		       return clearSsn;
		     }
		     */
}
