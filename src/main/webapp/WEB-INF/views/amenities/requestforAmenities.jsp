<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Request For Amenity</title>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div>
		<input type="hidden" id="context" value="<%=request.getContextPath()%>" />
		<div id="container" style="padding-left: 34px;">
			<div>
				<span id="headerTitle"><b>Amenity Request</b></span> 
			</div>
			<form class="socuser" name="amenityRequestDetail" modelAttribute="amenityRequestDetailForm" method="POST">
				<fieldset class="profileDetails">
					<legend>Amenity Details </legend>
					<div class="container">
						<div class="personalInformation">
						<p>
							<label>Amenity Type </label> 
							<select id="amenityType">
							  <option value="none">---Select---</option>
							  <option value="badmintonCourt">Badminton Court</option>
							  <option value="clubhouse">Club House</option>
							  <option value="parking">Parking</option>
							  <option value="swimming">Swimming Pool</option>
							</select>
						</p>
						<p>
							<label>User Name </label>
							<input type="text" id="userName" />
						</p>
						<p>
							<label>Status </label> 
							<select id="amenityStatus">
							  <option value="none">---Select---</option>
							  <option value="approved">Approved</option>
							  <option value="applied">Applied</option>
							  <option value="inprogress">In Progress</option>
							  <option value="expired">Expired</option>
							</select>
						</p>
						<p>
							<label>Start Date </label> <input type="text"  id="startdate" />
						</p>
						<p>
							<label>End Date </label> <input type="text"  id="enddate" />
						</p>
						<p>
							<label>Amenity Notes </label>
							<textarea rows="3" cols="100"  id="amenityNotes"></textarea>
						</p>
						</div>
					</div>
				</fieldset>
				
				<fieldset class="row1">
					<div align="center" class="button-left">
						<input type="submit" class="button" value="Add" id="requestAmenity"/>
						<button class="button" id="cancelRequest">Cancel</button>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
	<script language="javascript" type="text/javascript">
		debugger;
		$(document).ready(function() {
			$("#startdate").datepicker();
			$("#enddate").datepicker();
			
			$("#requestAmenity").click(function(){
				requestAmenity();
				return false;
			});
			
			$("#cancelRequest").click(function(){
				window.location.href = $('#context').val() + "/amenities/search";
				return false;
			});
			
			function requestAmenity(){
				debugger;
				var requestAmenityUrl = $('#context').val() + "/amenities/save";
				var amenityRequestDetailForm = {};
				amenityRequestDetailForm.amenityType = $('#amenityType').val();
				amenityRequestDetailForm.userName = $('#userName').val();
				amenityRequestDetailForm.amenityStatus = $('#amenityStatus').val();
				amenityRequestDetailForm.startdate = $('#startdate').val();
				amenityRequestDetailForm.enddate = $('#enddate').val();
				amenityRequestDetailForm.amenityNotes = $('#amenityNotes').val();
				
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