<jsp:include page="../../includes/header.jsp"/>


<table width="100%" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td class="mainBkgr">
			<jsp:include page="../../includes/menu.jsp" flush="true"/>
		</td>
		<td width="100%" align="left" valign="top" class="mainBkgr" >
			<div id="boxContent"> 
				<div id="breadcrumb">
					&nbsp;&nbsp;Home > Front Office > Guest Folio
				</div>
				
				
				<table width="470" cellpadding="0" cellspacing="0" border="0">
				<tr>
				<td>
						
						<table width="450" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td colspan="3" class="header1">Guest Folio</td>
						</tr>
						</table>
						
						<table cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td><div id="field">Room</div></td>
							<td></td>
							<td></td>
							<td><div id="field">Last Name</div></td>
							<td><div id="field">First Name</div></td>
						</tr>
						<tr>
							<td ><div id="field"><input type="text" name="room" value="" size="20" maxlength="13" class="textbox"/></div></td>
							<td valign="center" align="left"><a href="#"><img src="<%=request.getContextPath() %>/images/lookup.png" alt="Retrieve Folio by Room Number" title="Retrieve Folio by Room Number" /></a><br/></td>
							<td><div id="field"><b>OR</b></div></td>
							<td><div id="field"><input type="text" name="lastname" value="" size="30" maxlength="30" class="textbox"/></div></td>
							<td><div id="field"><input type="text" name="firstname" value="" size="30" maxlength="30" class="textbox"/></div></td>
							<td valign="top" align="left"><a href="#"><img src="<%=request.getContextPath() %>/images/lookup.png" alt="Retrieve Folio by Guest Name" title="Retrieve Folio by Guest Name" /></a></td>
						
						</tr>
						</table>
		
				</td>
				</tr>
				</table>
					
				<table width="100%" cellpadding="0" cellspacing="0" border="0">
				<tr>
					<td align="right" valign="bottom" height="50" style="padding-right:30px">
						<input type="submit" name="action" value="Print Folio" class="button"/>
						<input type="submit" name="action" value="Cancel" class="button"/>
						<br/><br/>
					</td>
				</tr>
				</table>	
				
			</div>
		</td>
	</tr>
</table>



<jsp:include page="../../includes/footer.jsp"/>


