<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Amenities</title>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<br/>
	<input type="hidden" id="context" value="<%=request.getContextPath()%>" />
	<div>
		<span id="searchTitle" > <b>Search Amenities</b></span> 
	</div>
	<br/>
	<div id="example">
		<div id="amenityGrid"></div>
		<div style="padding-top: 15px;"><span width="100%"></span></div>
		<div>
			<button class="button" id="updateAmenity">Update</button>
		</div>
	</div>
	<script language="javascript" type="text/javascript">
        $(document).ready(function () {
            $("#amenityGrid").kendoGrid({
			    dataSource: {
			        transport: {
			            read:  $('#context').val()+"/amenities/viewAllAmenities",
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
			    	template: "<div align=right><a href='"+ $('#context').val()+"/amenities/view/#: amenityId #'>#: amenityId #</a></div>",
			        field: "amenityId",
			        title: "Amenity #",
			        width: 80
			    }, {
			        field: "amenityType",
			        title: "Amenity Type",
			        width: 150
			    },{
			        field: "amenityStatus",
			        title: "Amenity Status"
			    }, {
			        field: "startDate",
			        title: "Start Date",
			       	width: 150
			    }, {
			        field: "endDate",
			        title: "End Date",
			        width: 150
			    }, {
			        field: "userName",
			        title: "Assigned To",
			        width: 150
			    }]
			});
            
            $("#updateAmenity").click(function(){
            	console.log("Update button is clicked");
				var amenityGrid = $("#amenityGrid").data("kendoGrid");
				var selectedAmenity = amenityGrid.dataItem(amenityGrid.select());
				if(selectedAmenity !== null){	
					console.log("Selected Amenity :" + selectedAmenity.amenityId);
					location.href = $('#context').val() + "/amenities/update/"+ selectedAmenity.amenityId;
					return false;
				}
				return false;
			});
        });
    </script>

</body>
</html>