<jsp:include page="../../includes/header.jsp"/>


<table width="100%" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td class="mainBkgr">
			<jsp:include page="../../includes/menu.jsp" flush="true"/>
		</td>
		<td width="100%" align="left" valign="top" class="mainBkgr" >
			<div id="boxContent"> 
				<div id="breadcrumb">
					&nbsp;&nbsp;Home > Front Office > Reservation
				</div>
				
				
				<table width="470" cellpadding="0" cellspacing="0" border="0">
				<tr>
				<td>
						
						<table width="450" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td colspan="3" class="header1">Reservation</td>
						</tr>
						</table>
						
						<table cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td class="header2" ><img src="<%=request.getContextPath()%>/images/star_bullet.png"/>Conf#</td>
							<td></td>
						</tr>
						<tr>
							<td ><div id="field"><input type="text" name="confirmation" value="" size="20" maxlength="13" class="textbox"/></div></td>
							<td valign="center" align="left"><a href="#"><img src="<%=request.getContextPath() %>/images/lookup.png" alt="Search For Existing Reservation" title="Search For Existing Reservation" /></a><br/></td>
						</tr>
						</table>
						
						<table width="450" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td colspan="2" class="header2"><br/><img src="<%=request.getContextPath()%>/images/star_bullet.png"/>Check In Date</td>
						</tr>
						<tr>
							<td valign="top" width="250">
								<div id="field">
									<input type="text" name="checkinDate" value="" size="20" maxlength="13" class="tcal"/>
									&nbsp;<b><i>for</i></b>&nbsp;
									<select name="nights" class="select">
										<option value="1">1 NIGHT</option>
										<option value="2">2 NIGHTS</option>
										<option value="3">3 NIGHTS</option>
									</select>
									&nbsp;
								</div>
							</td>
							<td valign="center" align="left"><a href="#"><img src="<%=request.getContextPath() %>/images/lookup.png" alt="Check Availability" title="Check Availability" /></a></td>
						</tr>
						</table>
						
						<table width="210" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td colspan="2"><div id="field">Room Type</div></td>
						</tr>
						<tr>
							<td valign="top">
								<div id="field">
									<select name="nights" class="select">
										<option value="1">King Bed Non-smoking</option>
										<option value="2">King Bed Smoking</option>
										<option value="3">Double Bed Non-smoking</option>
										<option value="3">Double Bed Smoking</option>
										<option value="3">King Suite</option>
										<option value="3">Executive Suite</option>
									</select>
								</div>
							</td>
							<td valign="center" align="left"><a href="#"><img src="<%=request.getContextPath() %>/images/lookup.png" alt="Check Availability" title="Check Availability" /></a></td>
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
							<td><div id="field"><input type="text" name="lastname" value="" size="30" maxlength="30" class="textbox"/></div></td>
							<td><div id="field"><input type="text" name="firstname" value="" size="30" maxlength="30" class="textbox"/></div></td>
							<td><div id="field"><input type="text" name="suffix" value="" size="5" maxlength="5" class="textbox"/></div></td>
							<td valign="top" align="left"><a href="#"><img src="<%=request.getContextPath() %>/images/lookup.png" alt="Search For Guest Profile" title="Search For Guest Profile" /></a></td>
						</tr>
						</table>
						
						
						<table width="250" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td><div id="field">Organization</div></td>
						</tr> 
						<tr>
							<td><div id="field"><input type="text" name="organization" value="" size="100" maxlength="80" class="textbox"/></div></td>
						</tr>
						</table>
						
						<table width="250" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td><div id="field">Address Line 1</div></td>
						</tr> 
						<tr>
							<td><div id="field"><input type="text" name="line1" value="" size="100" maxlength="80" class="textbox"/></div></td>
						</tr>
						</table>
						
						<table width="250" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td><div id="field">Address Line 2</div></td>
						</tr> 
						<tr>
							<td><div id="field"><input type="text" name="line1" value="" size="100" maxlength="80" class="textbox"/></div></td>
						</tr>
						</table>
						
						
						<table width="340" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td><div id="field">City</div></td>
							<td><div id="field">State</div></td>
							<td><div id="field">Zipcode</div></td>
						</tr> 
						<tr>
							<td><div id="field"><input type="text" name="city" value="" size="20" maxlength="30" class="textbox"/></div></td>
							<td><div id="field">
								<select name="state" class="select">
									<option value=""></option>
									<option value="">ALABAMA</option>
									<option value="">ARKANSAS</option>
									<option value="">NORTH CAROLINA</option>
									
								</select>
							</div></td>
							<td><div id="field"><input type="text" name="zipcode" value="" size="15" maxlength="15" class="textbox"/></div></td>
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
							<td><div id="field"><input type="text" name="email" value="" size="60" maxlength="60" class="textbox"/></div></td>
						</tr>
						</table>
						
						
				</td>
				<td width="50%" align="left" valign="top">
						
						<br/>
						<table width="450" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td height="15"></td>
						</tr>
						<tr>
							<td><div id="field">
								Requested Amentities:<br/>					
								&nbsp;&nbsp;<input type="checkbox" name="" value=""/>Adjoining&nbsp;&nbsp;
								<input type="checkbox" name="" value=""/>Accessible&nbsp;&nbsp;
								<input type="checkbox" name="" value=""/>Sleeper&nbsp;&nbsp;
								<input type="checkbox" name="" value=""/>Roll-a-way&nbsp;&nbsp;
								<input type="checkbox" name="" value=""/>Crib&nbsp;&nbsp;<br/>
								&nbsp;&nbsp;<input type="checkbox" name="" value=""/>mini-fridge&nbsp;&nbsp;
								<input type="checkbox" name="" value=""/>microwave&nbsp;&nbsp;
								<input type="checkbox" name="" value=""/>kitchenette&nbsp;&nbsp;
								<input type="checkbox" name="" value=""/>Smoking 
								</div>
							</td>
						</tr>
						</table>
						<br/>
						<table width="100%" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td width="150"><div id="field">Voucher Code</div></td>
							<td><div id="field">Rewards Number</div></td>
						</tr>
						<tr>
							<td valign="top" >
								<div id="field"><input type="text" name="voucherCode" value="" size="20" maxlength="15" class="textbox" /></div>
							</td>
							<td valign="top" >
								<div id="field"><input type="text" name="rewardsNumber" value="" size="20" maxlength="15" class="textbox" /></div>
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
								<div id="field"><textarea name="notes" value="" id="styled" ></textarea></div>
								<br/>
							</td>
							<td width="60%"></td>
						</tr>
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
				
			</div>
		</td>
	</tr>
</table>



<jsp:include page="../../includes/footer.jsp"/>


