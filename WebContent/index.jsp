<jsp:include page="includes/header.jsp"/>

<table width="100%" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td class="mainBkgr">
			<jsp:include page="includes/menu.jsp" flush="true"/>
		</td>
		<td width="100%" align="left" valign="top" class="mainBkgr" >
			<div id="boxContent"> 
				<div id="breadcrumb">
					&nbsp;&nbsp;Home
				</div>
				
				
				<table width="100%" height="550" cellpadding="0" cellspacing="0" border="0">
				<tr>
				<td width="100%" background="<%=request.getContextPath()%>/images/courtyard-by-marriott.jpg" valign="top">
					<jsp:include page="includes/messages.jsp" flush="true"/>	
				</td>
				</tr>
				</table>	
				
			</div>
		</td>
	</tr>
</table>

<jsp:include page="includes/footer.jsp"/>


