<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Amenity</title>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div>
		<input type="hidden" id="context" value="<%=request.getContextPath()%>" />
		<input type="hidden" id="selAmenityType" value="${amenityDetails.amenityType}" />
		<input type="hidden" id="selAmenityStatus" value="${amenityDetails.amenityStatus}" />
		<input type="hidden" id="userId" value="${amenityDetails.userId }"/>
		
		<div id="container" style="padding-left: 34px;">
			<div>
				<span id="headerTitle"><b>Update Amenity - ${amenityId}</b></span> 
			</div>
			<form class="socuser" name="amenityRequestDetail" modelAttribute="amenityRequestDetailForm" method="POST">
				<fieldset class="profileDetails">
					<legend>Amenity Details </legend>
					<div class="container">
						<div class="personalInformation">
						<p>
							<label>Amenity # </label>
							<input type="text" id="amenityId" value="${amenityId}" disabled/>
						</p>
						<p>
							<label>Amenity Type </label> 
							<select id="amenityType" disabled>
							  <option value="none">---Select---</option>
							  <option value="badmintonCourt">Badminton Court</option>
							  <option value="clubhouse">Club House</option>
							  <option value="parking">Parking</option>
							  <option value="swimming">Swimming Pool</option>
							</select>
						</p>
						<p>
							<label>User Name </label>
							<input type="text" id="userName" value ="${amenityDetails.userName}" disabled/>
						</p>
						<p>
							<label>Status </label> 
							<select id="amenityStatus" disabled>
							  <option value="none">---Select---</option>
							  <option value="approved">Approved</option>
							  <option value="applied">Applied</option>
							  <option value="inprogress">In Progress</option>
							  <option value="expired">Expired</option>
							</select>
						</p>
						<p>
							<label>Start Date </label> 
							<input type="text"  id="startdate" value ="${amenityDetails.startDate}"/>
						</p>
						<p>
							<label>End Date </label> 
							<input type="text"  id="enddate" value ="${amenityDetails.endDate}"/>
						</p>
						<p>
							<label>Amenity Notes </label>
							<textarea rows="3" cols="100"  id="amenityNotes">${amenityDetails.notes}</textarea>
						</p>
						</div>
					</div>
				</fieldset>
				
				<fieldset class="row1">
					<div align="center" class="button-left">
						<input type="submit" class="button" value="Update" id="updateAmenity"/>
						<button class="button" id="cancelUpdateAmenity">Cancel</button>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
	<script language="javascript" type="text/javascript">
		debugger;
		$(window).load(function (){
			$('#amenityType').val($('#selAmenityType').val()).trigger("chosen:updated");
			$('#amenityStatus').val($('#selAmenityStatus').val()).trigger("chosen:updated");
		});
		
		$(document).ready(function() {
			$("#startdate").datepicker();
			$("#enddate").datepicker();
			
			$("#updateAmenity").click(function(){
				updateAmenity();
				return false;
			});
			
			$("#cancelUpdateAmenity").click(function(){
				location.href = $('#context').val() + "/amenities/search";
				return false;
			});
			
			function updateAmenity(){
				debugger;
				var requestAmenityUrl = $('#context').val() + "/amenities/save";
				var amenityRequestDetailForm = {};
				amenityRequestDetailForm.amenityId = $('#amenityId').val();
				amenityRequestDetailForm.amenityType = $('#amenityType').val();
				amenityRequestDetailForm.userName = $('#userName').val();
				amenityRequestDetailForm.amenityStatus = $('#amenityStatus').val();
				amenityRequestDetailForm.startDate = $('#startdate').val();
				amenityRequestDetailForm.endDate = $('#enddate').val();
				amenityRequestDetailForm.notes = $('#amenityNotes').val();
				amenityRequestDetailForm.userId = $('#userId').val();
				
				$.ajax({
					  type: "POST",
					  url: requestAmenityUrl,
					  data: JSON.stringify(amenityRequestDetailForm),
					  dataType: "json",
					  contentType : "application/json",
					  success: function(data){
						  window.location.href = $('#context').val() + "/amenities/search";
						  return false;
					  },
					  error: function(data){
						  window.alert("Amenity Request is failed");
						  return false;
					  }
				});
				return false;
			};
		});
	</script>
</body>
</html>