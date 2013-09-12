<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.seascape.roomstar.domain.RoomType" %>
<% List list = null; %>
<jsp:include page="../../includes/header.jsp"/>


<table width="100%" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td class="mainBkgr">
			<jsp:include page="../../includes/menu.jsp" flush="true"/>
		</td>
		<td width="100%" align="left" valign="top" class="mainBkgr" >
			<div id="boxContent"> 
				<div id="breadcrumb">
					&nbsp;&nbsp;Home > Front Office > Walk In
				</div>
				
										
				<table width="450" cellpadding="0" cellspacing="0" border="0">
				<tr>
					<td colspan="3" class="header1">Walk In Guest</td>
				</tr>
				</table>
		
				<html:form action="/WalkIn">
				<jsp:include page="../../includes/messages.jsp" flush="true"/>
				<% if ((String)session.getAttribute("confirmation")!=null) { %>
				     <div style="padding-left:10px">
						<table width="434" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td width="434" height="65" background="<%=request.getContextPath()%>/images/info_header.jpg" ></td>
						</tr>
						<tr>
							<td background="<%=request.getContextPath()%>/images/info_body.jpg" valign="top" >
								<div id="info">Reservation has been saved.  Confirmation number is  <b><%=(String)session.getAttribute("confirmation") %></b></div>
							</td>
						</tr>
				 		<tr>
							<td width="434" height="10" background="<%=request.getContextPath()%>/images/info_footer.jpg" ></td>
						</tr>
						</table>
					</div>
				<% session.removeAttribute("confirmation");
				} 
				%>
				<table width="470" cellpadding="0" cellspacing="0" border="0">
				<tr>
				<td>
						
						<table width="400" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td class="header2"><img src="<%=request.getContextPath()%>/images/star_bullet.png"/>Check In Date</td>
							<td colspan="2" class="header2"><img src="<%=request.getContextPath()%>/images/star_bullet.png"/>Check Out Date</td>
						</tr>
						<tr>
							<td valign="top" width="140">
								<div id="field">
									<html:text property="reservation.checkInDate" size="20" maxlength="13" styleClass="tcal" />
								</div>
							</td>
							<td valign="top" width="140">
								<div id="field">
									<html:text property="reservation.checkOutDate" size="20" maxlength="13" styleClass="tcal" />
								</div>
							</td>
							<td valign="center" align="left"><a href="#"><img src="<%=request.getContextPath() %>/images/lookup.png" alt="Check Availability" title="Check Availability" /></a></td>
						</tr>
						</table>
						
						<table cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td><div id="field">Room Type</div></td>
							<td colspan="2"><div id="field">Room Rate</div></td>
						</tr>
						<tr>
							<td valign="top">
								<div id="field">
								
								<html:select property="reservation.roomTypeId" styleClass="select" >
								    <html:option value="">Select</html:option>
									<html:optionsCollection name="ddl_roomType" value="roomTypeId" label="name" />
								</html:select> 
								</div>
							</td>
							<td valign="top">
								<div id="field">	
								<html:select property="reservation.rateTypeId" styleClass="select" >
								    <html:option value="">Select</html:option>
									<html:optionsCollection name="ddl_rateType" value="rateTypeId" label="name" />
								</html:select>
								</div>
							</td>
							<td valign="top><a href="#"><img src="<%=request.getContextPath() %>/images/lookup.png" alt="Check Availability" title="Check Availability" /></a></td>
						</tr>
						
						</table>
						<br/>
						
						<table width="250" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td colspan="3" class="header2"><img src="<%=request.getContextPath()%>/images/star_bullet.png"/>Guest Information</td>
						</tr>
						<tr>
							<td><div id="field">Last Name</div></td>
							<td><div id="field">First Name</div></td>
							<td><div id="field">Suffix</div></td>
						</tr> 
						<tr>
							<td><div id="field"><html:text property="customer.lastname" size="30" maxlength="30" styleClass="textbox" /></div></td>
							<td><div id="field"><html:text property="customer.firstname" size="30" maxlength="30" styleClass="textbox" /></div></td>
							<td><div id="field"><html:text property="customer.suffix" size="3" maxlength="3" styleClass="textbox" /></div></td>
							<td valign="top" align="left"><a href="#"><img src="<%=request.getContextPath() %>/images/lookup.png" alt="Search For Guest Profile" title="Search For Guest Profile" /></a></td>
						</tr>
						</table>
						
						
						<table width="250" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td><div id="field">Organization</div></td>
						</tr> 
						<tr>
							<td><div id="field"><html:text property="customer.organization" size="100" maxlength="80" styleClass="textbox" /></div></td>
						</tr>
						<tr>
							<td ><div id="field">Address Type</div></td>
						</tr>
						<tr>
							<td valign="top">
								<div id="field">
								<html:select property="address.addressTypeId" styleClass="select" >
									<html:optionsCollection name="ddl_addressType" value="addressTypeId" label="addressTypeDesc" />
								</html:select> 
								</div>
							</td>
						</table>
						
						<table width="250" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td><div id="field">Address Line 1</div></td>
						</tr> 
						<tr>
							<td><div id="field"><html:text property="address.line1" size="100" maxlength="80" styleClass="textbox" /></div></td>
						</tr>
						</table>
						
						<table width="250" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td><div id="field">Address Line 2</div></td>
						</tr> 
						<tr>
							<td><div id="field"><html:text property="address.line1" size="100" maxlength="80" styleClass="textbox" /></div></td>
						</tr>
						</table>
						
						
						<table width="340" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td><div id="field">City</div></td>
							<td><div id="field">State</div></td>
						</tr> 
						<tr>
							<td><div id="field"><html:text property="address.city" size="20" maxlength="30" styleClass="textbox" /></div></td>
							<td><div id="field">
								<html:select property="address.state" styleClass="select" >
									<html:option value="">Select</html:option>
									<html:optionsCollection name="ddl_state" value="value" label="label" />
								</html:select>
							</div></td>
						</tr>
						</table>
						
						<table width="340" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td><div id="field">Zipcode</div></td>
							<td><div id="field">Country</div></td>
						</tr> 
						<tr>
							<td><div id="field"><html:text property="address.zipcode" size="15" maxlength="15" styleClass="textbox" /></div></td>
							<td><div id="field">
								<html:select property="address.country" styleClass="select" >
								    <html:option value="">Select</html:option>
									<html:optionsCollection name="ddl_country" value="iso" label="printableName" />
								</html:select> 
							</div></td>
						</tr>
						</table>
						
						
						<table width="450" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td><div id="field">Contact Phone</div></td>
							<td><div id="field">Email Address</div></td>
						</tr> 
						<tr>
							<td><div id="field">
								(<input type="text" name="phone1" value="" size="3" maxlength="3" class="textbox"/>)
								<input type="text" name="phone2" value="" size="3" maxlength="3" class="textbox"/>
								-<input type="text" name="phone3" value="" size="4" maxlength="4" class="textbox"/></div>
							</td>
							<td><div id="field"><html:text property="address.email" size="60" maxlength="60" styleClass="textbox" /></div></td>
						</tr>
						</table>
						
						<table width="450" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td height="15"></td>
						</tr>
						<tr>
							<td><div id="field">
								Requested Amentities:					
								</div>
							</td>
						</tr>
						<tr>
							<td><div id="field">
								<html:select property="customer.rewardsNumber" multiple="true"> 
									<html:optionsCollection name="ddl_amentity" value="amentityId" label="name" />
								</html:select>
								</div>
							</td>
						</tr>
						</table>
				</td>
				<td width="50%" align="left" valign="top">
						
						<br/>
						<table width="100%" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td width="150"><div id="field">Voucher Code</div></td>
							<td><div id="field">Rewards Number</div></td>
						</tr>
						<tr>
							<td valign="top" >
								<div id="field"><html:text property="reservation.voucherCode" size="20" maxlength="15" styleClass="textbox" /></div>
							</td>
							<td valign="top" >
								<div id="field"><html:text property="reservation.rewardsNumber" size="20" maxlength="15" styleClass="textbox" /></div>
							</td>
							<td valign="center" align="left"><a href="#"><img src="<%=request.getContextPath() %>/images/lookup.png" alt="Lookup Rewards Number" title="Lookup Rewards Number" /></a></td>
							<td width="60%"></td>
						</tr>
						</table>
						
						<table width="100%" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td width="150"><div id="field">Notes</div></td>
						</tr>
						<tr>
							<td valign="top" >
								<div id="field"><html:textarea property="reservation.notes" styleClass="textarea" /></div>
								<br/>
							</td>
							<td width="60%"></td>
						</tr>
						</table>							
												
						<table width="100%" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td align="left" valign="bottom" style="padding-left:10px;">
								<jsp:include page="../../grids/messages.jsp" flush="true"/>
							</td>
						</tr>
						<tr><td height="5"></td></tr>
						</table>
						
						<table width="100%" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td align="left" valign="bottom" style="padding-left:10px;">
								<jsp:include page="../../grids/guest_history.jsp" flush="true"/>
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
						<input type="submit" name="action" value="Print Folio" class="button"/>
						<input type="submit" name="action" value="Email Confirmation" class="button"/>
						<input type="submit" name="action" value="Cancel" class="button"/>
						<br/><br/>
					</td>
				</tr>
				</table>	
				</html:form>
			</div>
		</td>
	</tr>
</table>



<jsp:include page="../../includes/footer.jsp"/>


