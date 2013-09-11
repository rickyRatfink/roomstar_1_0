<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<style>

#errors {
	font: .80em Arial;
	color: #c30923;
	text-align:left;
	padding-left:40px;
	vertical-align:top;
	padding-top:0px;
}

#info {
	font: .80em Arial;
	color: #3c7ac0;
	text-align:left;
	padding-left:40px;
	vertical-align:top;
	padding-top:0px;
}

#success {
	font: .80em Arial;
	color: #77c06b;
	text-align:left;
	padding-left:40px;
	vertical-align:top;
	padding-top:0px;
}

#warning {
	font: .80em Arial;
	color: #878314;
	text-align:left;
	padding-left:40px;
	vertical-align:top;
	padding-top:0px;
}

</style>


<% 
	String display=(String)request.getAttribute("notifications");
%>


<% if ("error".equals(display)) { %>
<table width="437" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td width="437" height="66" background="<%=request.getContextPath()%>/images/error_header.jpg"></td>
		</tr>
		<tr>
			<td background="<%=request.getContextPath()%>/images/error_body.jpg" valign="top">
				<div id="errors"><html:errors/></div>
			</td>
		</tr>
 		<tr>
			<td width="437" height="12" background="<%=request.getContextPath()%>/images/error_footer.jpg"></td>
		</tr>
		</table>
</logic:messagesPresent> 
<% } %>

<% if ("info".equals(display)) { %>
<logic:messagesPresent>
		<table width="434" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td width="434" height="65" background="<%=request.getContextPath()%>/images/info_header.jpg"></td>
		</tr>
		<tr>
			<td background="<%=request.getContextPath()%>/images/info_body.jpg" valign="top">
				<div id="info"><html:errors/></div>
			</td>
		</tr>
 		<tr>
			<td width="434" height="10" background="<%=request.getContextPath()%>/images/info_footer.jpg"></td>
		</tr>
		</table>
</logic:messagesPresent> 
<% } if ("success".equals(display)) { %>
<logic:messagesPresent>
		<table width="434" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td width="434" height="65" background="<%=request.getContextPath()%>/images/success_header.jpg"></td>
		</tr>
		<tr>
			<td background="<%=request.getContextPath()%>/images/success_body.jpg" valign="top">
				<div id="success"><html:errors/></div>
			</td>
		</tr>
 		<tr>
			<td width="434" height="10" background="<%=request.getContextPath()%>/images/success_footer.jpg"></td>
		</tr>
		</table>
</logic:messagesPresent> 
<% } if ("warning".equals(display)) { %>
<logic:messagesPresent>
		<table width="434" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td width="434" height="65" background="<%=request.getContextPath()%>/images/warning_header.jpg"></td>
		</tr>
		<tr>
			<td background="<%=request.getContextPath()%>/images/warning_body.jpg" valign="top">
				<div id="warning"><html:errors/></div>
			</td>
		</tr>
 		<tr>
			<td width="434" height="10" background="<%=request.getContextPath()%>/images/warning_footer.jpg"></td>
		</tr>
		</table>
</logic:messagesPresent> 
<% } %>		