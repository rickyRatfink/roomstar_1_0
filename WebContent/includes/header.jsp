<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/menu.css" media="screen">
<link href="<%=request.getContextPath()%>/css/tcal.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/script/tcal.js"></script>
  
<title>RoomStar (Lodging Management System)</title>


<script type="text/javascript">

function toggleVisibility(sId) {
	
if (sId=='FrontOffice') {
	document.getElementById('FrontOffice').style.visibility = "visible";
	document.getElementById('Housekeeping').style.visibility = "hidden";
	document.getElementById('Engineering').style.visibility = "hidden";
	document.getElementById('HR').style.visibility = "hidden";
	document.getElementById('Accounting').style.visibility = "hidden";
	document.getElementById('SalesMarketing').style.visibility = "hidden";
	document.getElementById('Inventory').style.visibility = "hidden";
	document.getElementById('Reports').style.visibility = "hidden";
}
if (sId=='Housekeeping') {
	document.getElementById('FrontOffice').style.visibility = "hidden";
	document.getElementById('Housekeeping').style.visibility = "visible";
	document.getElementById('Engineering').style.visibility = "hidden";
	document.getElementById('HR').style.visibility = "hidden";
	document.getElementById('Accounting').style.visibility = "hidden";
	document.getElementById('SalesMarketing').style.visibility = "hidden";
	document.getElementById('Inventory').style.visibility = "hidden";
	document.getElementById('Reports').style.visibility = "hidden";
}
if (sId=='Engineering') { 
	document.getElementById('FrontOffice').style.visibility = "hidden";
	document.getElementById('Housekeeping').style.visibility = "hidden";
	document.getElementById('Engineering').style.visibility = "visible";
	document.getElementById('HR').style.visibility = "hidden";
	document.getElementById('Accounting').style.visibility = "hidden";
	document.getElementById('SalesMarketing').style.visibility = "hidden";
	document.getElementById('Inventory').style.visibility = "hidden";
	document.getElementById('Reports').style.visibility = "hidden";
}
if (sId=='HR') {
	document.getElementById('FrontOffice').style.visibility = "hidden";
	document.getElementById('Housekeeping').style.visibility = "hidden";
	document.getElementById('Engineering').style.visibility = "hidden";
	document.getElementById('HR').style.visibility = "visible";
	document.getElementById('Accounting').style.visibility = "hidden";
	document.getElementById('SalesMarketing').style.visibility = "hidden";
	document.getElementById('Inventory').style.visibility = "hidden";
	document.getElementById('Reports').style.visibility = "hidden";
}


if (sId=='HR') {
	document.getElementById('FrontOffice').style.visibility = "hidden";
	document.getElementById('Housekeeping').style.visibility = "hidden";
	document.getElementById('Engineering').style.visibility = "hidden";
	document.getElementById('HR').style.visibility = "visible";
	document.getElementById('Accounting').style.visibility = "hidden";
	document.getElementById('SalesMarketing').style.visibility = "hidden";
	document.getElementById('Inventory').style.visibility = "hidden";
	document.getElementById('Reports').style.visibility = "hidden";
}
if (sId=='Accounting') {
	document.getElementById('FrontOffice').style.visibility = "hidden";
	document.getElementById('Housekeeping').style.visibility = "hidden";
	document.getElementById('Engineering').style.visibility = "hidden";
	document.getElementById('HR').style.visibility = "hidden";
	document.getElementById('Accounting').style.visibility = "visible";
	document.getElementById('SalesMarketing').style.visibility = "hidden";
	document.getElementById('Inventory').style.visibility = "hidden";
	document.getElementById('Reports').style.visibility = "hidden";
}
if (sId=='SalesMarketing') {
	document.getElementById('FrontOffice').style.visibility = "hidden";
	document.getElementById('Housekeeping').style.visibility = "hidden";
	document.getElementById('Engineering').style.visibility = "hidden";
	document.getElementById('HR').style.visibility = "hidden";
	document.getElementById('Accounting').style.visibility = "hidden";
	document.getElementById('SalesMarketing').style.visibility = "visible";
	document.getElementById('Inventory').style.visibility = "hidden";
	document.getElementById('Reports').style.visibility = "hidden";
}
if (sId=='Inventory') {
	document.getElementById('FrontOffice').style.visibility = "hidden";
	document.getElementById('Housekeeping').style.visibility = "hidden";
	document.getElementById('Engineering').style.visibility = "hidden";
	document.getElementById('HR').style.visibility = "hidden";
	document.getElementById('Accounting').style.visibility = "hidden";
	document.getElementById('SalesMarketing').style.visibility = "hidden";
	document.getElementById('Inventory').style.visibility = "visible";
	document.getElementById('Reports').style.visibility = "hidden";
}
if (sId=='Reports') {
	document.getElementById('FrontOffice').style.visibility = "hidden";
	document.getElementById('Housekeeping').style.visibility = "hidden";
	document.getElementById('Engineering').style.visibility = "hidden";
	document.getElementById('HR').style.visibility = "hidden";
	document.getElementById('Accounting').style.visibility = "hidden";
	document.getElementById('SalesMarketing').style.visibility = "hidden";
	document.getElementById('Inventory').style.visibility = "hidden";
	document.getElementById('Reports').style.visibility = "visible";
}

/*
if(document.getElementById(sId).style.visibility == "hidden" ) {
    document.getElementById(sId).style.visibility = "visible";
}
else {
  document.getElementById(sId).style.visibility = "hidden";
}
*/
}
</script>

</head>

<body>

<div id="footer">

	<table width="100%" cellpadding="0" cellspacing="0" border="0">
	<tr>
	<td width="100%" background="<%=request.getContextPath() %>/images/footer_bg.png">
		<div id="item">Property Name:&nbsp;&nbsp;&nbsp;</div><div id="itemValue">Courtyard By Marriott. 45th Street. WPB, FL</div>
		<div id="item">User Name:&nbsp;&nbsp;&nbsp;</div><div id="itemValue">Administrator</div>
		<div id="item">System Date:&nbsp;&nbsp;&nbsp;</div><div id="itemValue"><%= new java.util.Date() %></div>
		<div id="item">Active Shift:&nbsp;&nbsp;&nbsp;</div><div id="itemValue">Mid Shift 3P-11P</div>
	</td>
	<td alight="right"  background="<%=request.getContextPath() %>/images/footer_bg.png"><img src="<%=request.getContextPath() %>/images/flags.png"/></td>
	</tr>
	</table>
	
</div>

<!-- 
<div id="preheader" align="right" style="padding-top:5px;">
	<img src="<%=request.getContextPath() %>/images/flags.png"/>
</div>
 -->

<div id="header">
	<div id="logo" align="right"><img src="<%=request.getContextPath() %>/images/globe.png" /></div>
</div>


<table width="100%" cellpadding="0" cellspacing="0" border="0">
<tr>
<td width="740">
<ul class="menu">
	<li id="FO"><a href="#" onclick="toggleVisibility('FrontOffice');">Front Office</a></li>
	<li><a href="#" onclick="toggleVisibility('Housekeeping');">Housekeeping</a></li>
	<li><a href="#" onclick="toggleVisibility('Engineering');">Engineering</a></li>
	<li><a href="#" onclick="toggleVisibility('HR');">Human Resources</a></li>
	<li><a href="#" onclick="toggleVisibility('Inventory');">Inventory</a></li>
	<li><a href="#" onclick="toggleVisibility('SalesMarketing');">Sales & Marketing</a></li>
	<li><a href="#" onclick="toggleVisibility('Accounting');">Accounting</a></li>
	<li><a href="#" onclick="toggleVisibility('Reports');">Reports</a></li>
</ul> 
</td>
<td bgcolor="#ffffff" width="100%" style="border-left: 1px solid #6f9dd9;"></td>
</tr>
</table>


<table width="100%" cellpadding="0" cellspacing="0" border="0">
<tr>
	<td width="100%" bgcolor="6f9dd9" height="1"></td>
</tr>

</table>


