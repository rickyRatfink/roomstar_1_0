<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/jquery/js/jquery-ui-1.8.1.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/jquery/js/ui.jqgrid.css" />
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/jquery/js/ui.multiselect.css" />


<script type="text/javascript" src="<%=request.getContextPath()%>/jquery/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/jquery/js/jquery-ui-1.8.2.custom.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery/js/grid.locale-en.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery/js/jquery.jqGrid.min.js"></script>
<script type="text/javascript"> 



$(document).ready(function() {

	$("#list1").jqGrid({

	    //url:'http://seascapesolutions.com:8080<%=request.getContextPath()%>/grid?type=student',
	    url:'http://localhost:8080<%=request.getContextPath()%>/grid?type=student',
	    colNames:['Room Type','Rate','Available','Booked','Amentities'],
	    colModel:[
	              {name:'intake_id',index:'intake_id', width:50,sortable:true},
	              {name:'lastname',index:'lastname', width:50,sortable:true},
	              {name:'lastname',index:'lastname', width:50,sortable:true},
	              {name:'lastname',index:'lastname', width:50,sortable:true},
	              {name:'dob',index:'dob', width:400}],
	    rowNum:20,
	    rowList:[20,10,5],
	    pager: '#pager1',
	    sortname: 'intake_id',
	    datatype: 'xml',
	    viewrecords: true,
	    sortorder: "desc",
	    multiselect: false,	 
	    height: 156 ,
	    width: $(window).width()-290,
	    caption: "Room Availability" });

	   
});	    

function selectRow () {

	//alert( jQuery('#list1').jqGrid('getGridParam','selrow') );
	document.getElementById('key').value=jQuery('#list1').jqGrid('getGridParam','selrow');
}
</script>


	<table id="list1" class="scroll" cellpadding="0" cellspacing="0" width="50%" >
	</table>
	
	<div id="pager1" class="scroll" style="text-align: center;"></div>
				
