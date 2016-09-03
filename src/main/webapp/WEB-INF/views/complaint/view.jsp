<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Complaint</title>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div>
		<input type="hidden" id="context" value="<%=request.getContextPath()%>" />
		<input type="hidden" id="complaintId" value="${complaintId}"/>
		<div id="container" style="padding-left: 34px;">
			<div>
				<span id="headerTitle"><b>View Complaint - ${complaintId}</b></span> 
			</div>
			<form class="socuser" id="complaintViewForm">
				<fieldset class="profileDetails">
					<legend>Complaint Details </legend>
					<div class="container">
						<div class="personalInformation">
						<p>
							<label>Compliant # </label>
							<span class="viewName">${complaintId} </span>
						</p>
						<p>
							<label>Complaint Type </label>
							<span class="viewName">${complaintDetails.complaintType} </span> 							
						</p>
						<p>
							<label>Description </label>
							<span class="viewName">${complaintDetails.complaintDescription} </span>
						</p>
						<p>
							<label>Mobile </label> 
							<span class="viewName">${complaintDetails.phoneNo} </span>
						</p>
						<p>
							<label>Status </label> 
							<span class="viewName">${complaintDetails.complaintStatus} </span>
						</p>
						<p>
							<label>Available Time </label> 
							<span class="viewName">${complaintDetails.availableTime} </span>
						</p>
						<p>
							<label>Complaint Log </label>
							<span class="viewName">${complaintDetails.complaintLog} </span>
						</p>
						</div>
					</div>
				</fieldset>
				
				<fieldset class="row1">
					<div align="center" class="button-left">
						<input type="submit" class="button" value="Update" id="updateComplaint"/>
						<button class="button" id="cancelComplaint">Cancel</button>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
	<script language="javascript" type="text/javascript">
		debugger;
		$( document ).ready(function() {
		    $('#complaintViewForm').submit(function(){
		    	 location.href = $('#context').val() +"/complaint/update/"+$('#complaintId').val();
		    	 return false;
		    });
		    
		    $("#cancelComplaint").click(function(){
				window.location.href = $('#context').val() + "/complaint/search";
				return false;
			});
		});
	</script>
</body>
</html>