<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.seascape.roomstar.domain.RoomType" %>
<% List list = null; %>
<jsp:include page="../../../includes/header.jsp"/>


<table width="100%" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td class="mainBkgr">
			<jsp:include page="../../../includes/menu.jsp" flush="true"/>
		</td>
		<td width="100%" align="left" valign="top" class="mainBkgr" >
			<div id="boxContent"> 
				<div id="breadcrumb">
					&nbsp;&nbsp;Home > Administration > Configuration > Rate Types
				</div>
				
										
				<table width="450" cellpadding="0" cellspacing="0" border="0">
				<tr>
					<td colspan="3" class="header1">Rate Type</td>
				</tr>
				</table>
		
				<html:form action="/Config">
				<jsp:include page="messages.jsp" flush="true"/>
				<% if ("YES".equals((String)session.getAttribute("saved"))) { %>
				     <div style="padding-left:10px">
						<table width="434" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td width="434" height="65" background="<%=request.getContextPath()%>/images/info_header.jpg" ></td>
						</tr>
						<tr>
							<td background="<%=request.getContextPath()%>/images/info_body.jpg" valign="top" >
								<div id="info">Rate type has been saved.</b></div>
							</td>
						</tr>
				 		<tr>
							<td width="434" height="10" background="<%=request.getContextPath()%>/images/info_footer.jpg" ></td>
						</tr>
						</table>
					</div>
				<% session.removeAttribute("saved");
				} 
				%>
				<table width="470" cellpadding="0" cellspacing="0" border="0">
				<tr>
				<td>
						
						<table cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td><div id="field">Display Name</div></td>
						</tr>
						<tr>
							<td valign="top">
								<div id="field">
									<html:text property="rateType.name" size="20" maxlength="40" styleClass="textbox" />
								</div>
							</td>
						</tr>
						
						<tr>
							<td><div id="field">Value</div></td>
						</tr>
						<tr>
							<td valign="top">
								<div id="field">
									<html:text property="rateType.value" size="10" maxlength="10" styleClass="textbox" />
								</div>
							</td>
						</tr>
						
						</table>
						<br/>
						
						<table width="100%" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td align="left" valign="bottom" style="padding-left:10px;">
								<jsp:include page="../../../grids/guest_history.jsp" flush="true"/>
							</td>
						</tr>
						</table>
				</td>
				</tr>
				</table>				
					
				<table width="100%" cellpadding="0" cellspacing="0" border="0">
				<tr>
					<td align="right" valign="bottom" height="50" style="padding-right:30px">
						<input type="submit" name="action" value="Save" class="button"/>
						<input type="submit" name="action" value="Cancel" class="button"/>
						<br/><br/>
					</td>
				</tr>
				</table>	
				<input type="hidden" name="entity" value="rateType"/>
				</html:form>
			</div>
		</td>
	</tr>
</table>



<jsp:include page="../../../includes/footer.jsp"/>


