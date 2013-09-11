<jsp:include page="../includes/header.jsp"/>


<table width="100%" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td class="mainBkgr">
		<div id="boxContent">
			    <table width="100%" cellpadding="0" cellspacing="0" border="0">
				<tr>
				<td valign="top" width="90">
					<img src="<%=request.getContextPath()%>/images/errorPage.jpg" %>
				</td>
				<td align="left">
					<table width="100%" cellpadding="0" cellspacing="0" border="0">
					<tr>
				       <td valign="top">
							<h4><b>Server Error Has Occurred:</b></h4>
						</td>
					</tr>
						<td valign="top" style="padding-left:10px;">
						The following error details have been reported by the server application:<br/>
						<i><%= request.getParameter("SYSTEM_ERR") %></i> 
						<br/>
						</td>
					</tr>
					</table>	
				</td>
				</tr>
				</table>
		</div>
		</td>
	</tr>
</table>



<jsp:include page="../includes/footer.jsp"/>

		