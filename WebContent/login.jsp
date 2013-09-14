<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head> 
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<style>

body {
	background: #dbebff;
	margin-top:0px;
	margin-left:0px;
	margin-right:0px;
	font:"Arial";
	color:#000000;
	font-size: 1.0em;;
}

#table {
	
}
.login {
	height: 200px;
	width: 350px;
	border:1px solid #456879;
	background:#ffffff;
	-moz-border-radius:5px;
    -webkit-border-radius:5px;
    border-radius:5px;
    -moz-box-shadow:1px 1px 4px #666;
    -webkit-box-shadow:1px 1px 4px #666;
    box-shadow:1px 1px 4px #666;
	font: 10px Arial;
	color: #444446;
}

#input {
}
.textbox { 
	width:160px;
	height: 15px; padding: 2px 0 0px 2px; 
	border:1px solid #193a96;
	border-radius:3px;
	font-family: sans-serif; font-size: 10px; color: #000000; 
	margin-bottom:5px;
	background:#f5faff;
}
.button{
   border: 1px solid #8ec1da;
   background-color: #ddeef6;
   border-radius: 4px;
   box-shadow: inset 0 1px 3px #fff, inset 0 -15px #cbe6f2, 0 0 3px #8ec1da;
   -o-box-shadow: inset 0 1px 3px #fff, inset 0 -15px #cbe6f2, 0 0 3px #8ec1da;
   -webkit-box-shadow: inset 0 1px 3px #fff, inset 0 -15px #cbe6f2, 0 0 3px #8ec1da;
   -moz-box-shadow: inset 0 1px 3px #fff, inset 0 -15px #cbe6f2, 0 0 3px #8ec1da;
   color: #3985a8;
   text-shadow: 0 1px #fff;
   padding: 1px 20px;
   height: 20px;
}

#errors {
	font: 1.10em Arial;
	color: #c30923;
	text-align:left;
	padding-right:10px;
	vertical-align:top;
}

#td {
}
.errors {
	font: .98em Arial;
	color: #c30923;
	text-align:left;
	padding-right:10px;
	vertical-align:top;
}

.loginTitle {
	font: .85em verdana;
	font-weight:none;
	color: #000000;
	padding-left:40px;
	padding-bottom:0px;
	vertical-align:bottom;
}
.loginInstructions {
	font: .85em verdana;
	font-weight:none;
	color: #000000;
	padding-left:50px;
	padding-right:30px;
	padding-bottom:10px;
	vertical-align:bottom;
}
.fieldTitle {
	font: 1.05em verdana;
	font-weight:bold;
	color: #000000;
	text-align:left;
	padding-left:50px;
	padding-bottom:0px;
	vertical-align:bottom;
}
.fieldInput {
	text-align:left;
	padding-left:50px;
	padding-bottom:0px;
	padding-top:0px;
	vertical-align:top;
}
.buttons {
	height:40px;
	padding-right:30px;
	padding-bottom:10px;
}

</style>
   
<body>
	<div align="center">	
		<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
		
		<html:form action="/Login" focus="username">
		
		<table class="login" cellpadding="0" cellspacing="0" border="0">
			<tr>
				<td valign="top" style="padding-top:10px;">
					<img src="<%=request.getContextPath() %>/images/logo2.png"
				</td>
				<td class="version">
					LMS Version 1.0.0<br/>
					build date: Sep 12, 2013<br/>
					Seascape Solution &copy;2013-2014
				</td>
			</tr>
			
			<tr>
            	<td class="loginTitle" colspan="2"><img src="<%=request.getContextPath() %>/images/loginTitle.png"/></td>
            </tr>
            <tr>
            	<td class="loginInstructions" colspan="2">
            		Enter your username and password to access the system.  Please contact
            		your system administrator if you have problems accessing your account.</br>
            	</td>
            </tr>
            <tr>
            	<td colspan="2" style="padding-left:25px;"><div id="errors"><html:errors/></div></td>
            </tr>
			<tr>
            	<td class="fieldTitle" colspan="2">username</td>
            </tr>
            <tr>
            	<td class="fieldInput" colspan="2">
            		<html:text property="employee.username" size="20" maxlength="20" styleClass="textbox"></html:text>
            	</td>
            </tr>
            <tr>
            	<td class="fieldTitle" colspan="2">password</td>
            </tr>
            <tr>
            	<td class="fieldInput" colspan="2">
            		<html:password property="employee.password" size="20" maxlength="20" styleClass="textbox"></html:password>
            		
           		</td>
            </tr>
            <tr>
            	<td class="buttons" align="right" colspan="2">
            		</br>
            		<input type="submit" name="action" value="Login" class="button"/>
            		<input type="submit" name="action" value="Clear" class="button"/>
            		
            	</td>
            </tr>
		</table>
		</html:form>
 	</div>
			
</body>
</html>
