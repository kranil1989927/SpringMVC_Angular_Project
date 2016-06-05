<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Complaint</title>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<br/>
	<input type="hidden" id="context" value="<%=request.getContextPath()%>" />
	<div>
		<span id="searchTitle" > <b>Search Complaint</b></span> 
	</div>
	<br/>
	<div id="example">
		<div id="complaintGrid"></div>
		<div style="padding-top: 15px;"><span width="100%"></span></div>
		<div>
			<button class="button" id="editComplaint">Update</button>
		</div>
	</div>
	<script language="javascript" type="text/javascript">
        $(document).ready(function () {
            $("#complaintGrid").kendoGrid({
			    dataSource: {
			        transport: {
			            read:  $('#context').val()+"/complaint/viewAllComplaint",
			            dataType: "JSON"
			        },
			        pageSize: 5
			    },
			    selectable: true,
			    height: 265,
			    sortable: true,
			    pageable: {
			        refresh: true,
			        pageSizes: true,
			        buttonCount: 5
			    },
			    columns: [
			       {
			    	template: "<div><a href='"+ $('#context').val()+"/complaint/view/#: complaintNo #'>#: complaintNo #</a></div>",
			        field: "complaintNo",
			        title: "Complaint #",
			        width: 100
			    }, {
			        field: "complaintType",
			        title: "Complaint Type",
			        width: 150
			    },{
			        field: "complaintDescription",
			        title: "Complaint Description"
			    }, {
			        field: "complaintStatus",
			        title: "Complaint Status",
			       	width: 150
			    }, {
			        field: "availableTime",
			        title: "Available Time",
			        width: 150
			    }]
			});
        });
    </script>

</body>
</html>