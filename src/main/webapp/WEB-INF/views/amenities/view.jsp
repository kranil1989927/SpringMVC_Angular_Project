<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Amenity</title>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div>
		<input type="hidden" id="context" value="<%=request.getContextPath()%>" />
		<input type="hidden" id="amenityId" value="${amenityId}"/>
		<input type="hidden" id="userId" value="${amenityDetails.userId }"/>
		
		<div id="container" style="padding-left: 34px;">
			<div>
				<span id="headerTitle"><b>View Amenity - ${amenityId}</b></span> 
			</div>
			<form class="socuser" id="amenityViewForm">
				<fieldset class="profileDetails">
					<legend>Amenity Details </legend>
					<div class="container">
						<div class="personalInformation">
						<p>
							<label>Amenity # </label>
							<span class="viewName">${amenityId} </span>
						</p>
						<p>
							<label>Amenity Type </label>
							<span class="viewName">${amenityDetails.amenityType} </span> 							
						</p>
						<p>
							<label>User Name </label>
							<span class="viewName">${amenityDetails.userName} </span>
						</p>
						<p>
							<label>Status </label> 
							<span class="viewName">${amenityDetails.amenityStatus} </span>
						</p>
						<p>
							<label>Start Date </label> 
							<span class="viewName">${amenityDetails.startDate} </span>
						</p>
						<p>
							<label>End Date </label> 
							<span class="viewName">${amenityDetails.endDate} </span>
						</p>
						<p>
							<label>Amenity Notes</label>
							<span class="viewName">${amenityDetails.notes} </span>
						</p>
						</div>
					</div>
				</fieldset>
				
				<fieldset class="row1">
					<div align="center" class="button-left">
						<input type="submit" class="button" value="Update" id="updateAmenity"/>
						<button class="button" id="cancelAmenity">Cancel</button>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
	<script language="javascript" type="text/javascript">
		debugger;
		$( document ).ready(function() {
		    $('#amenityViewForm').submit(function(){
		    	 location.href = $('#context').val() +"/amenities/update/"+$('#amenityId').val();
		    	 return false;
		    });
		    
		    $("#cancelAmenity").click(function(){
				window.location.href = $('#context').val() + "/amenities/search";
				return false;
			});
		});
	</script>
</body>
</html>