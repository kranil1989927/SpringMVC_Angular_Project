<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Complaint</title>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div>
		<input type="hidden" id="context" value="<%=request.getContextPath()%>" />
		<div id="container" style="padding-left: 34px;">
			<div>
				<span id="headerTitle"><b>Update Complaint - ${complaintId}</b></span> 
			</div>
			<form class="socuser" name="complaintDetail" modelAttribute="complaintDetailForm" method="POST">
				<fieldset class="profileDetails">
					<legend>Complaint Details </legend>
					<div class="container">
						<div class="personalInformation">
						<p>
							<label>Compliant # </label>
							<input type="text" id="complaintId" value="${complaintId}"/>
						</p>
						<p>
							<label>Complaint Type </label> 
							<select id="complaintType">
							  <option value="none">---Select---</option>
							  <option value="Electric">Electrical</option>
							  <option value="Plumber">Plumber</option>
							  <option value="Painting">Painting</option>
							</select>
						</p>
						<p>
							<label>Description </label>
							<textarea rows="3" cols="100"  id="complaintDesc">${complaintDetails.complaintDescription}</textarea>
						</p>
						<p>
							<label>Mobile </label> 
							<input type="text" id="phoneNo"  value ="${complaintDetails.phoneNo}"/>
						</p>
						<p>
							<label>Status </label> 
							<select id="complaintStatus">
							  <option value="none">---Select---</option>
							  <option value="Open">Open</option>
							  <option value="Close">Close</option>
							  <option value="In Progress">In Progress</option>
							</select>
						</p>
						<p>
							<label>Available Time </label> 
							<input type="text"  id="availableTime" value ="${complaintDetails.availableTime}"/>
						</p>
						<p>
							<label>Complaint Log </label>
							<textarea rows="3" cols="100"  id="complaintLog" >${complaintDetails.complaintLog}</textarea>
						</p>
						</div>
					</div>
				</fieldset>
				
				<fieldset class="row1">
					<div align="center" class="button-left">
						<input type="submit" class="button" value="Update" id="updateComplaint"/>
						<button class="button">Cancel</button>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
	<script language="javascript" type="text/javascript">
		debugger;
		$(document).ready(function() {
			$("#availableTime").datepicker();
			
			$("#updateComplaint").click(function(){
				submitComplaint();
				return false;
			});
			
			function submitComplaint(){
				debugger;
				var addComplaintUrl = $('#context').val() + "/complaint/save";
				var complainForm = {};
				complainForm.complaintType = $('#complaintType').val();
				complainForm.complaintDescription = $('#complaintDesc').val();
				complainForm.phoneNo = $('#phoneNo').val();
				complainForm.availableTime = $('#availableTime').val();
				complainForm.complaintStatus = $('#complaintStatus').val();
				complainForm.complaintLog = $('#complaintLog').val();
				
				$.ajax({
					  type: "POST",
					  url: addComplaintUrl,
					  data: JSON.stringify(complainForm),
					  dataType: "json",
					  contentType : "application/json",
					  success: function(data){
						  window.alert("Complaint Added");
						  return false;
					  },
					  error: function(data){
						  window.alert("Complaint Added failed");
						  return false;
					  }
				});
				return false;
			};
		});
	</script>
</body>
</html>